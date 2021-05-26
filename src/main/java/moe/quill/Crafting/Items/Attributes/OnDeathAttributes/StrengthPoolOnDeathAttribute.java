package moe.quill.Crafting.Items.Attributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StrengthPoolOnDeathAttribute extends LingeringPotionOnDeathAttribute{
    public StrengthPoolOnDeathAttribute(NamespacedKey key) {
        super(key,
                new PotionEffect(PotionEffectType.INCREASE_DAMAGE,120,1),
                Component.text("Strength Pool").color(TextColor.color(0xDA2211)),
                1,
                400,
                400
        );
    }
}
