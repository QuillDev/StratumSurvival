package moe.quill.Crafting.Items.Attributes.OnDeathAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnDeathStrengthPoolAttribute extends OnDeathLingeringPotionAttribute {
    public OnDeathStrengthPoolAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(materialManager, keyManager, AttributeKey.ON_DEATH_STRENGTH_POOL_ATTRIBUTE,
                new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 120, 1),
                Component.text("Strength Pool").color(TextColor.color(0xDA2211)),
                1,
                400,
                400
        );
    }
}
