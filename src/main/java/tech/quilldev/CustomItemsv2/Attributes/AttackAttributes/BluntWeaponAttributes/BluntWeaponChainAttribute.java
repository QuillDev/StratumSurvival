package tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItemsv2.Effects.ChainDamageEffect;

public class BluntWeaponChainAttribute extends BluntWeaponAttribute {

    private static final ChainDamageEffect chainDamageEffect = new ChainDamageEffect();

    public BluntWeaponChainAttribute(NamespacedKey key) {
        super(key,
                Component.text("Chain Damage").color(TextColor.color(0xe04bfa)),
                .17f,
                .1f,
                1f
        );
    }

    @Override
    public String dataFormat(float value) {
        return ": " + Math.round(value * 100) + "%";
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        if (modifier < rand.nextFloat()) return;
        chainDamageEffect.execute(sourceEvent, 5, modifier / 2f);
    }
}
