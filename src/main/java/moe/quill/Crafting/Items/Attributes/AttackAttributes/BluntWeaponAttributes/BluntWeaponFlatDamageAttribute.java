package moe.quill.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.Effects.BonusDamageEffect;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;

public class BluntWeaponFlatDamageAttribute extends BluntWeaponAttribute {

    private static final BonusDamageEffect bonusDamageEffect = new BonusDamageEffect();

    public BluntWeaponFlatDamageAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(
                materialManager,
                keyManager,
                AttributeKey.BLUNT_WEAPON_FLAT_DAMAGE_ATTRIBUTE,
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
