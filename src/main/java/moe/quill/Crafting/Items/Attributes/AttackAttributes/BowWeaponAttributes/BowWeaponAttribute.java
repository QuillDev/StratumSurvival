package moe.quill.Crafting.Items.Attributes.AttackAttributes.BowWeaponAttributes;

import moe.quill.Crafting.Items.Attributes.Attribute;
import moe.quill.Crafting.Items.Attributes.OnDeathAttributes.OnDeathAttribute;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;

import java.util.ArrayList;
import java.util.Collections;

public abstract class BowWeaponAttribute extends Attribute {

    protected final BowAttributeMethods bowAttributeMethods = new BowAttributeMethods();

    public BowWeaponAttribute(NamespacedKey key, Component lore, float scaleValue, float minRoll, float maxRoll) {
        super(key, lore, ItemLists.WEAPONS_BOW, scaleValue, minRoll, maxRoll, new ArrayList<>(
                Collections.singletonList(OnDeathAttribute.class)
        ));
    }
}
