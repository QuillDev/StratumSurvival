package tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes;

import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItemsv2.AttackAttributes.AttackAttribute;
import tech.quilldev.CustomItemsv2.WeaponLists;

public abstract class BluntWeaponAttribute extends AttackAttribute {
    public BluntWeaponAttribute(NamespacedKey key) {
        super(key, WeaponLists.BLUNT_WEAPONS);
    }
}
