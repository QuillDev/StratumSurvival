package tech.quilldev.ItemAttributes.OnHitAttributes.PotionBased;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AscendOnHitAttribute extends PotionOnHitAttribute {
    public AscendOnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText,
                new PotionEffect(PotionEffectType.LEVITATION, 15, 1),
                Component.text("LEVITATED").color(TextColor.color(0x36C61)));
    }
}
