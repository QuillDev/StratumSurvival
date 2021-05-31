package moe.quill.stratumsurvival.Crafting.Items.Attributes.OnDeathAttributes;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnDeathSpeedPoolAttribute extends OnDeathLingeringPotionAttribute {
    public OnDeathSpeedPoolAttribute(MaterialManager materialManager, IKeyManager keyManager) {
        super(materialManager, keyManager, AttributeKey.ON_DEATH_SPEED_POOL_ATTRIBUTE,
                new PotionEffect(PotionEffectType.SPEED, 100, 1),
                Component.text("Speed Pool").color(TextColor.color(0x2963DA)),
                1,
                400,
                400
        );
    }
}
