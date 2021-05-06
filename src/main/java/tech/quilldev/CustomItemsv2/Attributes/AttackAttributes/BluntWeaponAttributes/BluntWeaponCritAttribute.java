package tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItemsv2.Attribute;
import tech.quilldev.CustomItemsv2.Effects.CritDamageEffect;

public class BluntWeaponCritAttribute extends BluntWeaponAttribute {

    private final static CritDamageEffect critDamageEffect = new CritDamageEffect();

    public BluntWeaponCritAttribute(NamespacedKey key) {
        super(key,
                Component.text("Critical Strike").color(TextColor.color(0xDAAF00)),
                .2f
        );
    }

    @Override
    public String dataFormat(float value) {
        return ": " + Math.round(value * 100) + "%";
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        if (modifier < Attribute.rand.nextFloat()) return;
        critDamageEffect.execute(sourceEvent, modifier);
    }
}
