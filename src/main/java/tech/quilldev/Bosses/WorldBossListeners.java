package tech.quilldev.Bosses;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Giant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.persistence.PersistentDataType;

public class WorldBossListeners implements Listener {

    private final WorldBossManager bossManager;

    public WorldBossListeners(WorldBossManager bossManager) {
        this.bossManager = bossManager;
    }

    @EventHandler
    public void onBossDeath(EntityDeathEvent event) {
        final var target = event.getEntity();
        if (!(target instanceof Giant)) return;
        final var targetData = target.getPersistentDataContainer();
        if (!targetData.has(bossManager.getWorldBossKey(), PersistentDataType.BYTE_ARRAY)) return;
        Bukkit.getServer().sendMessage(Component.text("The world boss has been slain!"));
        bossManager.getBossBar().removeAll();
    }

    @EventHandler
    public void onBossDamaged(EntityDamageByEntityEvent event) {
        final var sourceTarget = event.getEntity();
        if (!(sourceTarget instanceof Giant)) return;
        final var target = (Giant) sourceTarget;
        final var targetData = sourceTarget.getPersistentDataContainer();
        if (!targetData.has(bossManager.getWorldBossKey(), PersistentDataType.BYTE_ARRAY)) return;
        bossManager.getBossBar().setProgress(target.getHealth() / (20f * bossManager.getCombatantSize()));
    }
}
