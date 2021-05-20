package tech.quilldev.CustomItems.Effects;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;

public class EvokerFangEffect extends Effect {

    public void execute(Event sourceEvent) {
        var target = helper.getTargetLivingEntity(sourceEvent);

        target.getWorld().spawnEntity(target.getLocation(), EntityType.EVOKER_FANGS);
    }
}
