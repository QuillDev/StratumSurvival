package tech.quilldev.ItemAttributes.DamageAttribute.PotionBased;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VenomAttribute extends PotionAttribute {
    public VenomAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText,
                new PotionEffect(PotionEffectType.POISON, 80, 1),
                Component.text("POISONED").color(TextColor.color(0x6C06)));
    }
}
