package moe.quill.Crafting.Items.Attributes.AttackAttributes.BowWeaponAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

public class BowWeaponAttributeDamage extends BowWeaponAttribute {

    public BowWeaponAttributeDamage(NamespacedKey key) {
        super(key, Component.text("Arrow Damage").color(TextColor.color(0xFF513E)), 1, 1, 6);
    }

    @Override
    public String dataFormat(float value) {
        return attributeFormatter.formatFloat(value);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = bowAttributeMethods.getEventData(sourceEvent);
        if (eventData == null) return;
        eventData.getEvent().setDamage(eventData.getEvent().getDamage() + modifier);
    }
}
