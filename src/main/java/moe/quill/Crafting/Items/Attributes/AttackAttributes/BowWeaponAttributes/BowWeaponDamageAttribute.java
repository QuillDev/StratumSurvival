package moe.quill.Crafting.Items.Attributes.AttackAttributes.BowWeaponAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;

public class BowWeaponDamageAttribute extends BowWeaponAttribute {

    public BowWeaponDamageAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(materialManager, keyManager, AttributeKey.BOW_WEAPON_DAMAGE_ATTRIBUTE, Component.text("Arrow Damage").color(TextColor.color(0xFF513E)), 1, 1, 6);
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
