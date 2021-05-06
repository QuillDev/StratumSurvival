package tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BowWeaponAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItemsv2.Attribute;
import tech.quilldev.CustomItemsv2.WeaponLists;

import java.util.ArrayList;

public abstract class BowWeaponAttribute extends Attribute {
    public BowWeaponAttribute(NamespacedKey key, Component lore, float scaleValue, float minRoll, float maxRoll) {
        super(key, lore, WeaponLists.BOW_WEAPONS, scaleValue, minRoll, maxRoll, new ArrayList<>());
    }
}
