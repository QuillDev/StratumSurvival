package tech.quilldev.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItems.Effects.FlameEffect;

public class BluntWeaponFlameAttribute extends BluntWeaponAttribute {

    private final static FlameEffect flameEffect = new FlameEffect();

    public BluntWeaponFlameAttribute(NamespacedKey key) {
        super(key,
                Component.text("Burn Chance").color(TextColor.color(0xFF3824)),
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
        if (modifier < rand.nextFloat()) return;
        flameEffect.execute(sourceEvent);
    }
}
