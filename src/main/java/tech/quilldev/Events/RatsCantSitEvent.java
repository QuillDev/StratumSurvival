package tech.quilldev.Events;

import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class RatsCantSitEvent implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onSit(PlayerInteractEntityEvent event) {
        final var entity = event.getRightClicked();
        if (!(entity instanceof Wolf)) return;
        final var wolf = (Wolf) entity;
        final var name = entity.getCustomName();
        if (name == null) return;
        if (!entity.getCustomName().matches("(.*'s Rat)")) return;
        event.setCancelled(true);
        wolf.setSitting(false);
    }
}
