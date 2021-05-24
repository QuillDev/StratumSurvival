package moe.quill.Crafting.CustomItems.Attributes.AttackAttributes.BowWeaponAttributes;

import moe.quill.Crafting.CustomItems.Attributes.Attribute;
import moe.quill.Crafting.CustomItems.Attributes.OnDeathAttributes.OnDeathAttribute;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.WeaponHelpers.WeaponLists;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;

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
