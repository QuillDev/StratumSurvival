package moe.quill.Crafting.CustomItems.Effects;

import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class BonusDamageEffect extends Effect {
    public void execute(Event sourceEvent, float modifier) {
        if (!(sourceEvent instanceof EntityDamageByEntityEvent)) return;
        final var event = (EntityDamageByEntityEvent) sourceEvent;
        event.setDamage(event.getDamage() + modifier);

    }
}

