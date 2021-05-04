package tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.PotionBased;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VenomOnHitAttribute extends PotionOnHitAttributeWithParticle {
    public VenomOnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText,
                new PotionEffect(PotionEffectType.POISON, 80, 1),
                Component.text("POISONED").color(TextColor.color(0x6C06)),
                Particle.SPELL_WITCH
                );


    }
}
