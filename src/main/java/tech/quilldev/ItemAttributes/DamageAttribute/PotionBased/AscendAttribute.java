package tech.quilldev.ItemAttributes.DamageAttribute.PotionBased;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AscendAttribute extends PotionAttribute{
    public AscendAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText,
                new PotionEffect(PotionEffectType.LEVITATION, 15, 1),
                Component.text("LEVITATED").color(TextColor.color(0x36C61)));
    }
}
