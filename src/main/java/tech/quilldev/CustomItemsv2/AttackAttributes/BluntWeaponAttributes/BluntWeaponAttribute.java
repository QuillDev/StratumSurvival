package tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItemsv2.AttackAttributes.AttackAttribute;
import tech.quilldev.CustomItemsv2.WeaponLists;

public abstract class BluntWeaponAttribute extends AttackAttribute {
    public BluntWeaponAttribute(NamespacedKey key, Component lore, float scaleValue) {
        super(key, lore, WeaponLists.BLUNT_WEAPONS, scaleValue);
    }
}
