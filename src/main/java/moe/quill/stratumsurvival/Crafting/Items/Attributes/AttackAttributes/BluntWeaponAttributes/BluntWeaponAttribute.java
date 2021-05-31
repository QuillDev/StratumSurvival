package moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.AttackAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.stratumsurvival.Crafting.KeyManager;
import net.kyori.adventure.text.Component;

public abstract class BluntWeaponAttribute extends AttackAttribute {
    public BluntWeaponAttribute
            (
                    MaterialManager materialManager,
                    KeyManager keyManager,
                    AttributeKey key,
                    Component lore,
                    float scaleValue,
                    float minRoll,
                    float maxRoll
            ) {
        super(materialManager, keyManager, key, lore, ItemLists.WEAPONS_BLUNT, scaleValue, minRoll, maxRoll);
    }
}
