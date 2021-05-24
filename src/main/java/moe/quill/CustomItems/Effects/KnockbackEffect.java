package moe.quill.CustomItems.Effects;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;

public class KnockbackEffect extends Effect {

    public void execute(Event event, LivingEntity livingEntity, float modifier) {
        final var entity = helper.getLivingEntity(event);
        livingEntity.setVelocity(entity.getLocation().getDirection().multiply(-modifier));
    }
}
