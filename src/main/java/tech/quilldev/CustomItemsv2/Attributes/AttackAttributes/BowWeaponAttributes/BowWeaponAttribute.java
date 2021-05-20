package tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BowWeaponAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItemsv2.Attributes.Attribute;
import tech.quilldev.CustomItemsv2.Attributes.OnDeathAttributes.OnDeathAttribute;
import tech.quilldev.CustomItemsv2.MaterialManager.WeaponLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class BowWeaponAttribute extends Attribute {

    protected final BowAttributeMethods bowAttributeMethods = new BowAttributeMethods();

    public BowWeaponAttribute(NamespacedKey key, Component lore, float scaleValue, float minRoll, float maxRoll) {
        super(key, lore, WeaponLists.WEAPONS_BOW, scaleValue, minRoll, maxRoll, new ArrayList<>(
                Collections.singletonList(OnDeathAttribute.class)
        ));
    }
}
