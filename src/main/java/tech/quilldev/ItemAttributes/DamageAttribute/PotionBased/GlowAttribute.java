package tech.quilldev.ItemAttributes.DamageAttribute.PotionBased;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GlowAttribute  extends PotionAttribute{
    public GlowAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText,
                new PotionEffect(PotionEffectType.GLOWING, 200, 1),
                Component.text("HIGHLIGHTED").color(TextColor.color(0xDABE41)));
    }
}
