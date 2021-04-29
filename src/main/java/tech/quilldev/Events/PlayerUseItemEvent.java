package tech.quilldev.Events;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class PlayerUseItemEvent implements Listener {

    private final Plugin plugin;

    public PlayerUseItemEvent(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerUseItem(PlayerInteractEvent event) {
        final var player = event.getPlayer();
        final var target = player.getTargetBlock(50);
        final var holding = player.getInventory().getItemInMainHand();

        NamespacedKey key = new NamespacedKey(plugin, "doesLightning");

        if (holding.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)){
            assert target != null;
            player.getWorld().strikeLightning(target.getLocation());
        }
    }
}
