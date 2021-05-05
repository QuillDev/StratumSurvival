package tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItemsv2.Effects.BonusDamageEffect;

public class BluntWeaponFlatDamageAttribute extends BluntWeaponAttribute {

    private static final BonusDamageEffect bonusDamageEffect = new BonusDamageEffect();

    public BluntWeaponFlatDamageAttribute(NamespacedKey key) {
        super(key,
                Component.text("Bonus Damage").color(TextColor.color(0xf75134)),
                1f
        );
    }

    @Override
    public String dataFormat(float data) {
        return ": +" + data;
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        bonusDamageEffect.execute(sourceEvent, modifier);
    }
}