package tech.quilldev.ItemAttributes.DamageAttribute.PotionBased;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageAttribute;

import java.util.Random;

public class WitherAttribute extends PotionAttribute {
    public WitherAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText,
                new PotionEffect(PotionEffectType.WITHER, 80, 1),
                Component.text("WITHERED").color(TextColor.color(0x1E)));
    }
}
