package tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.PotionBased;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GlowOnHitAttribute extends PotionOnHitAttribute {
    public GlowOnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText,
                new PotionEffect(PotionEffectType.GLOWING, 200, 1),
                Component.text("HIGHLIGHTED").color(TextColor.color(0xDABE41)));
    }
}
