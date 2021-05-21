package tech.quilldev.CustomItems.Attributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LifePoolOnDeathAttribute extends LingeringPotionOnDeathAttribute{
    public LifePoolOnDeathAttribute(NamespacedKey key) {
        super(key,
                new PotionEffect(PotionEffectType.ABSORPTION,200,1),
                Component.text("Harvester of Life").color(TextColor.color(0xDA4840)),
                1,
                400,
                400
        );
    }
}
