package tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes;

import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItemsv2.Effects.BonusDamageEffect;

public class BluntWeaponFlatDamageAttribute extends BluntWeaponAttribute {

    private static final BonusDamageEffect bonusDamageEffect = new BonusDamageEffect();

    public BluntWeaponFlatDamageAttribute(NamespacedKey key) {
        super(key);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        bonusDamageEffect.execute(sourceEvent, modifier);
    }
}
