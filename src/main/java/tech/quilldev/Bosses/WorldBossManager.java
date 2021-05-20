package tech.quilldev.Bosses;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import tech.quilldev.Serialization.StratumSerialization;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class WorldBossManager {

    private final Plugin plugin;

    //TODO: Another manager class pls
    private final BukkitScheduler scheduler;
    private final NamespacedKey worldBossKey;

    //HP Bar for the world boss
    private final BossBar bossBar;
    int combatantSize = 1;


    public WorldBossManager(Plugin plugin) {
        this.plugin = plugin;
        this.worldBossKey = new NamespacedKey(plugin, "mob_world_boss");
        this.bossBar = Bukkit.createBossBar("", BarColor.RED, BarStyle.SOLID);
        this.scheduler = Bukkit.getScheduler();

        //Register the world boss listeners
        plugin.getServer().getPluginManager().registerEvents(new WorldBossListeners(this), plugin);
    }

    public void spawnWorldBoss(Location location) {
        final var boss = (Giant) location.getWorld().spawnEntity(location, EntityType.GIANT);
        final var nearbyPlayers = boss.getNearbyEntities(50, 50, 50).stream()
                .filter(entity -> entity instanceof Player)
                .map(entity -> (Player) entity)
                .collect(Collectors.toCollection(ArrayList::new));

        final var bossData = boss.getPersistentDataContainer();
        bossData.set(worldBossKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
        this.combatantSize = nearbyPlayers.size();
        boss.setHealth(20f * combatantSize);
        nearbyPlayers.forEach(bossBar::addPlayer);
        bossBar.setProgress(1f); //star the progress at the max
    }

    public void spawnWithDelay(Location location) {
        final var ticksTillSpawn = 20 * 60;

        Bukkit.getServer().sendMessage(
                Component.text("A world boss will spawn in")
                        .append(Component.space())
                        .append(Component.text(ticksTillSpawn / 20))
                        .append(Component.text("s"))
                        .color(TextColor.color(0xFF544D))
        );

        //Log when there's 30 seconds left
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            Bukkit.getServer().sendMessage(
                    Component.text("A world boss will spawn in")
                            .append(Component.space())
                            .append(Component.text(30))
                            .append(Component.text("s"))
                            .color(TextColor.color(0xFF544D))
            );
        }, 20 * 30);

        //Spawn the world boss after the ticks are up
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            spawnWorldBoss(location);
        }, ticksTillSpawn);
    }

    public BossBar getBossBar() {
        return bossBar;
    }

    public NamespacedKey getWorldBossKey() {
        return worldBossKey;
    }

    public int getCombatantSize() {
        return combatantSize;
    }
}
