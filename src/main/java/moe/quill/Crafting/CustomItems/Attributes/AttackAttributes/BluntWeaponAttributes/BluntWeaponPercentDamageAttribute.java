package moe.quill.Crafting.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.CustomItems.Effects.BonusDamageEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class BluntWeaponPercentDamageAttribute extends BluntWeaponAttribute {

    private static final BonusDamageEffect bonusDamageEffect = new BonusDamageEffect();

    public BluntWeaponPercentDamageAttribute(NamespacedKey key) {
        super(key,
                Component.text("Damage Multiplier").color(TextColor.color(0xf75134)),
                .2f,
                .1f,
                1f
        );
    }

    @Override
    public String dataFormat(float value) {
        return attributeFormatter.formatPercent(value);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        if (!(sourceEvent instanceof EntityDamageByEntityEvent)) return;
        final var event = (EntityDamageByEntityEvent) sourceEvent;

        bonusDamageEffect.execute(sourceEvent, ((float) event.getDamage() * modifier));
    }
}
