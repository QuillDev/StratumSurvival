package moe.quill.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import moe.quill.Crafting.Items.Attributes.AttackAttributes.AttackAttribute;

public abstract class BluntWeaponAttribute extends AttackAttribute {
    public BluntWeaponAttribute(AttributeKey key, Component lore, float scaleValue, float minRoll, float maxRoll) {
        super(key, lore, ItemLists.WEAPONS_BLUNT, scaleValue, minRoll, maxRoll);
    }
}
