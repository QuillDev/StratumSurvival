package moe.quill.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.CustomItems.Effects.BonusDamageEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

public class BluntWeaponFlatDamageAttribute extends BluntWeaponAttribute {

    private static final BonusDamageEffect bonusDamageEffect = new BonusDamageEffect();

    public BluntWeaponFlatDamageAttribute(NamespacedKey key) {
        super(key,
                Component.text("Bonus Damage").color(TextColor.color(0xf75134)),
                1f,
                .5f,
                5f
        );
    }

    @Override
    public String dataFormat(float value) {
        return attributeFormatter.formatFloat(value);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        bonusDamageEffect.execute(sourceEvent, modifier);
    }
}