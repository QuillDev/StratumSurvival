package tech.quilldev.Bosses;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.persistence.PersistentDataType;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WorldBossListeners implements Listener {

    private final WorldBossManager bossManager;
    private final HashMap<Player, Integer> dpsMap;

    public WorldBossListeners(WorldBossManager bossManager) {
        this.bossManager = bossManager;
        this.dpsMap = bossManager.getDpsMap();
    }

    @EventHandler
    public void onBossDamaged(EntityDamageByEntityEvent event) {
        final var sourceTarget = event.getEntity();
        if (!(sourceTarget instanceof Giant)) return;
        final var target = (Giant) sourceTarget;
        final var targetData = sourceTarget.getPersistentDataContainer();
        if (!targetData.has(bossManager.getWorldBossKey(), PersistentDataType.BYTE_ARRAY)) return;
        bossManager.getBossBar().setProgress(target.getHealth() / (20f * bossManager.getCombatantSize()));

        //Deal with DPS on the damage map
        var damager = event.getDamager();
        if (damager instanceof Arrow) {
            final var arrow = (Arrow) damager;
            final var shooter = arrow.getShooter();
            if (shooter instanceof Player) {
                damager = ((Player) shooter).getPlayer();
            }
        }

        if (!(damager instanceof Player)) return;
        final var player = ((Player) damager).getPlayer();
        if (player == null) return;

        //Add the players damage to the DPS map
        if (!dpsMap.containsKey(player)) {
            dpsMap.put(player, (int) event.getFinalDamage());
            return;
        }
        final var entry = dpsMap.get(player);
        dpsMap.replace(player, entry + (int) event.getFinalDamage());
    }

    @EventHandler
    public void onBossDeath(EntityDeathEvent event) {
        final var target = event.getEntity();
        if (!(target instanceof Giant)) return;
        final var targetData = target.getPersistentDataContainer();
        if (!targetData.has(bossManager.getWorldBossKey(), PersistentDataType.BYTE_ARRAY)) return;
        Bukkit.getServer().sendMessage(Component.text("The world boss has been slain!"));
        bossManager.getBossBar().removeAll();

        //Get nearby players
        final var nearbyPlayers = target.getLocation().getNearbyPlayers(50);
        var messageToSend = Component.empty();

        //Total damage dealt to the boss
        final var sum = dpsMap.values().stream().mapToInt(i -> i).sum();

        final var dpsList = new ArrayList<>(dpsMap.entrySet());
        dpsList.sort((a, b) -> {

            if (a.getValue() < b.getValue()) {
                return 1;
            } else if (a.getValue().equals(b.getValue())) {
                return 0;
            }
            return -1;
        });

        for (int index = 0; index < dpsList.size(); index++) {
            final var entry = dpsList.get(index);
            final var val = entry.getValue();
            final var key = entry.getKey();
            var componentToAppend = Component.text(key.getName())
                    .append(Component.text(" | "))
                    .append(Component.text(val))
                    .append(Component.text("DMG"))
                    .append(Component.text(" | "))
                    .append(Component.text((Math.round(((float) val / (float) sum) * 100f) * 100) / 100))
                    .append(Component.text("%"));

            if (index != dpsList.size() - 1) {
                componentToAppend = componentToAppend.append(Component.newline());
            }
            messageToSend = messageToSend.append(componentToAppend);
        }

        //Send the DPS message to all nearby players
        for (final var player : nearbyPlayers) {
            player.sendMessage(messageToSend);
        }

        //Reset the battle state
        dpsMap.clear();
        bossManager.setActiveBattle(false);
    }


}
