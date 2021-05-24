package moe.quill.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.CustomItems.MaterialManager.StratumMaterials.WeaponHelpers.WeaponLists;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import moe.quill.CustomItems.Attributes.AttackAttributes.AttackAttribute;

public abstract class BluntWeaponAttribute extends AttackAttribute {
    public BluntWeaponAttribute(NamespacedKey key, Component lore, float scaleValue, float minRoll, float maxRoll) {
        super(key, lore, WeaponLists.WEAPONS_BLUNT, scaleValue, minRoll, maxRoll);
    }
}
