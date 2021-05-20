package tech.quilldev.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItems.Attributes.AttackAttributes.AttackAttribute;
import tech.quilldev.CustomItems.MaterialManager.WeaponLists;

public abstract class BluntWeaponAttribute extends AttackAttribute {
    public BluntWeaponAttribute(NamespacedKey key, Component lore, float scaleValue, float minRoll, float maxRoll) {
        super(key, lore, WeaponLists.WEAPONS_BLUNT, scaleValue, minRoll, maxRoll);
    }
}
