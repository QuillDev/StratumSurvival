package tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes;

import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.CustomItemsv2.Effects.ChainDamageEffect;

public class BluntWeaponChainAttribute extends BluntWeaponAttribute {

    private static ChainDamageEffect chainDamageEffect = new ChainDamageEffect();

    public BluntWeaponChainAttribute(NamespacedKey key) {
        super(key);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        if (!(sourceEvent instanceof EntityDamageByEntityEvent)) return;
        chainDamageEffect.execute((EntityDamageByEntityEvent) sourceEvent, modifier, 5);
    }
}
