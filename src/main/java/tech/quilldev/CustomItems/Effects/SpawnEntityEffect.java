package tech.quilldev.CustomItems.Effects;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;

public class SpawnEntityEffect extends Effect {

    public void execute(Event sourceEvent, Location location, EntityType entityType) {
        location.getWorld().spawnEntity(location, entityType);
    }
}
