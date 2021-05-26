package moe.quill.Crafting.Items.Effects;

import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FlameEffect extends Effect {

    public void execute(Event sourceEvent) {
        if (!(sourceEvent instanceof EntityDamageByEntityEvent)) return;
        final var event = (EntityDamageByEntityEvent) sourceEvent;

        event.getEntity().setFireTicks(60);

    }
}
