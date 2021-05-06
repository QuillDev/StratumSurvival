package tech.quilldev.CustomItemsv2.Effects;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.CustomItemsv2.Effects.Effect;

public class FlameEffect extends Effect {

    public void execute(Event sourceEvent) {
        if (!(sourceEvent instanceof EntityDamageByEntityEvent)) return;
        final var event = (EntityDamageByEntityEvent) sourceEvent;

        event.getEntity().setFireTicks(60);

    }
}
