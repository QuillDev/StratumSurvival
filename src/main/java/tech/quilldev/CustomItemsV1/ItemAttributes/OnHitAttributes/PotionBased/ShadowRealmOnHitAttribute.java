package tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.PotionBased;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ShadowRealmOnHitAttribute extends PotionOnHitAttribute {
    public ShadowRealmOnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText,
                new PotionEffect(PotionEffectType.INVISIBILITY, 20, 1),
                Component.text("SHADOW REALMED").color(TextColor.color(0x2E0E84)));
    }
}
