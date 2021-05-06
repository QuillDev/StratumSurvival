package tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.CustomItemsv2.Effects.BonusDamageEffect;

public class BluntWeaponPercentDamageAttribute extends BluntWeaponAttribute{

    private static final BonusDamageEffect bonusDamageEffect = new BonusDamageEffect();

    public BluntWeaponPercentDamageAttribute(NamespacedKey key) {
        super(key,
                Component.text("Damage Multiplier").color(TextColor.color(0xf75134)),
                .2f
        );
    }

    @Override
    public String dataFormat(float value) {
        return ": +" + Math.round(value * 100) + "%";
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {

        final var event = (EntityDamageByEntityEvent) sourceEvent;

        bonusDamageEffect.execute(sourceEvent, ((float)event.getDamage() * modifier));
    }
}
