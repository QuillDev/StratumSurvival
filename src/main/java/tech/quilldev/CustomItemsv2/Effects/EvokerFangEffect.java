package tech.quilldev.CustomItemsv2.Effects;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EvokerFangEffect extends Effect{

    public void execute(Event sourceEvent) {
        var target = helper.getTargetLivingEntity(sourceEvent);
        var targetLocation = target.getLocation();

        target.getWorld().spawnEntity(target.getLocation(), EntityType.EVOKER_FANGS);
    }
}
