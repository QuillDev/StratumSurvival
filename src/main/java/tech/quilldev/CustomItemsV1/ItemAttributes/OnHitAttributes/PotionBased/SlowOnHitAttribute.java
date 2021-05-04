package tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.PotionBased;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SlowOnHitAttribute extends PotionOnHitAttribute {
    public SlowOnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText,
                new PotionEffect(PotionEffectType.SLOW, 80, 1),
                Component.text("SLOWED").color(TextColor.color(0xB0C3)));
    }
}
