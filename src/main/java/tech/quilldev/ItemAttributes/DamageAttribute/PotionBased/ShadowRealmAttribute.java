package tech.quilldev.ItemAttributes.DamageAttribute.PotionBased;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ShadowRealmAttribute extends PotionAttribute{
    public ShadowRealmAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText,
                new PotionEffect(PotionEffectType.INVISIBILITY, 20, 1),
                Component.text("SHADOW REALMED").color(TextColor.color(0x2E0E84)));
    }
}
