package moe.quill.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.Effects.FlameEffect;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;

public class BluntWeaponFlameAttribute extends BluntWeaponAttribute {

    private final static FlameEffect flameEffect = new FlameEffect();

    public BluntWeaponFlameAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(
                materialManager,
                keyManager,
                AttributeKey.BLUNT_WEAPON_FLAME_ATTRIBUTE,
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
