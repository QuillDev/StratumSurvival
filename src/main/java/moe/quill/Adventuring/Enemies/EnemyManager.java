package moe.quill.Adventuring.Enemies;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class EnemyManager {

    private final Plugin plugin;
    private final BukkitScheduler scheduler;

    public EnemyManager(Plugin plugin) {
        this.plugin = plugin;
        this.scheduler = Bukkit.getScheduler();
    }
}
