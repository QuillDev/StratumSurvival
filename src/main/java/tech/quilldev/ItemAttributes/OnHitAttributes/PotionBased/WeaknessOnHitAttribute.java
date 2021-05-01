package tech.quilldev.ItemAttributes.OnHitAttributes.PotionBased;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WeaknessOnHitAttribute extends PotionOnHitAttribute {
    public WeaknessOnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText,
                new PotionEffect(PotionEffectType.WEAKNESS, 30, 1),
                Component.text("WEAKENED").color(TextColor.color(0x6C2C33)));
    }
}
