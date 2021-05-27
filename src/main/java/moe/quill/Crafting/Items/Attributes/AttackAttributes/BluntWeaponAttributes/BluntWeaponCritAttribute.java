package moe.quill.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.Items.Attributes.Attribute;
import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.Effects.CritDamageEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

public class BluntWeaponCritAttribute extends BluntWeaponAttribute {

    private final static CritDamageEffect critDamageEffect = new CritDamageEffect();

    public BluntWeaponCritAttribute() {
        super(AttributeKey.BLUNT_WEAPON_CRIT_ATTRIBUTE,
                Component.text("Critical Strike").color(TextColor.color(0xDAAF00)),
                .2f,
                .05f,
                1f
        );
    }

    @Override
    public String dataFormat(float value) {
        return attributeFormatter.formatPercent(value);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        if (modifier < Attribute.rand.nextFloat()) return;
        critDamageEffect.execute(sourceEvent, modifier);
    }
}
