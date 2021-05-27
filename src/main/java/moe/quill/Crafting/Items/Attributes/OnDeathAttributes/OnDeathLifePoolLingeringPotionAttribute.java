package moe.quill.Crafting.Items.Attributes.OnDeathAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnDeathLifePoolLingeringPotionAttribute extends OnDeathLingeringPotionAttribute {
    public OnDeathLifePoolLingeringPotionAttribute() {
        super(AttributeKey.ON_DEATH_LIFE_POOL_ATTRIBUTE,
                new PotionEffect(PotionEffectType.ABSORPTION,200,1),
                Component.text("Life Pool").color(TextColor.color(0xDA4840)),
                1,
                400,
                400
        );
    }
}