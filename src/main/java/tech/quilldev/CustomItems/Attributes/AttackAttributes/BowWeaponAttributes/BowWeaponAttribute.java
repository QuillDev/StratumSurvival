package tech.quilldev.CustomItems.Attributes.AttackAttributes.BowWeaponAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItems.Attributes.Attribute;
import tech.quilldev.CustomItems.Attributes.OnDeathAttributes.OnDeathAttribute;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.WeaponHelpers.WeaponLists;

import java.util.ArrayList;
import java.util.Collections;

public abstract class BowWeaponAttribute extends Attribute {

    protected final BowAttributeMethods bowAttributeMethods = new BowAttributeMethods();

    public BowWeaponAttribute(NamespacedKey key, Component lore, float scaleValue, float minRoll, float maxRoll) {
        super(key, lore, WeaponLists.WEAPONS_BOW, scaleValue, minRoll, maxRoll, new ArrayList<>(
                Collections.singletonList(OnDeathAttribute.class)
        ));
    }
}
