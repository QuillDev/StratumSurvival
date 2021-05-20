package tech.quilldev.CustomItems.Effects;

import org.bukkit.event.Event;

public class KnockbackEffect extends Effect {

    public void execute(Event event, float modifier) {
        final var entity = helper.getLivingEntity(event);
        entity.setVelocity(entity.getLocation().getDirection().multiply(-modifier));
    }
}
