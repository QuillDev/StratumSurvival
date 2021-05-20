package tech.quilldev.CustomItems.Attributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedPoolOnDeathAttribute extends LingeringPotionOnDeathAttribute{
    public SpeedPoolOnDeathAttribute(NamespacedKey key) {
        super(key,
                new PotionEffect(PotionEffectType.SPEED,100,1),
                Component.text("Harvester of Speed").color(TextColor.color(0x2963DA)));
    }
}
