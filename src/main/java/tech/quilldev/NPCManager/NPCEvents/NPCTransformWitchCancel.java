package tech.quilldev.NPCManager.NPCEvents;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTransformEvent;

public class NPCTransformWitchCancel implements Listener {

    @EventHandler
    public void cancelNPCWitchTransformation(EntityTransformEvent event) {
        final var entity = event.getEntity(); //get the entity
        if (!entity.getType().equals(EntityType.VILLAGER)) return; //if it's not a villager, ignore
        if (!event.getTransformReason().equals(EntityTransformEvent.TransformReason.LIGHTNING)) return; //if it's not lightning event, ignore
        if (entity.getPersistentDataContainer().getKeys().size() == 0) return; //if it's not a special villager, ignore
        event.setCancelled(true); //cancel the event
    }
}
