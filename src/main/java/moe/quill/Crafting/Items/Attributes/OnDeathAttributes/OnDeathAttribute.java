package moe.quill.Crafting.Items.Attributes.OnDeathAttributes;

import moe.quill.Crafting.Items.Attributes.Attribute;
import moe.quill.Crafting.Items.Attributes.AttributeKey;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;

import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;

public abstract class OnDeathAttribute extends Attribute {

    public OnDeathAttribute(AttributeKey key,
                            Component lore,
                            float scaleValue,
                            float minRoll,
                            float maxRoll
    ) {
        super(key, lore,
                //Weapons this attribute can be applied to
                new ArrayList<>(),
                scaleValue,
                minRoll,
                maxRoll,
                //TODO: Later might want to make weapon on death for bows and blunt separate
                new ArrayList<>()
        );
    }

    protected OnDeathAttributeData getEventData(Event sourceEvent) {
        if (!(sourceEvent instanceof EntityDeathEvent)) return null;
        final var event = (EntityDeathEvent) sourceEvent;
        final var target = event.getEntity();
        final var player = target.getKiller();
        if (player == null) return null;
        return new OnDeathAttributeData(player, target, event);
    }
}
