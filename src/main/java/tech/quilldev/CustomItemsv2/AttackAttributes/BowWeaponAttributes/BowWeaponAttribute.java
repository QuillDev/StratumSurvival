package tech.quilldev.CustomItemsv2.AttackAttributes.BowWeaponAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItemsv2.Attribute;
import tech.quilldev.CustomItemsv2.WeaponLists;

public abstract class BowWeaponAttribute extends Attribute {
    public BowWeaponAttribute(NamespacedKey key, Component lore, float scaleValue) {
        super(key, lore, WeaponLists.BOW_WEAPONS, scaleValue);
    }
}
