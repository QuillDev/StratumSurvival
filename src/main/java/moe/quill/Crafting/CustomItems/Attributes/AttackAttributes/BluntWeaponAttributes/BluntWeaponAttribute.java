package moe.quill.Crafting.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import moe.quill.Crafting.CustomItems.Attributes.AttackAttributes.AttackAttribute;

public abstract class BluntWeaponAttribute extends AttackAttribute {
    public BluntWeaponAttribute(NamespacedKey key, Component lore, float scaleValue, float minRoll, float maxRoll) {
        super(key, lore, ItemLists.WEAPONS_BLUNT, scaleValue, minRoll, maxRoll);
    }
}
