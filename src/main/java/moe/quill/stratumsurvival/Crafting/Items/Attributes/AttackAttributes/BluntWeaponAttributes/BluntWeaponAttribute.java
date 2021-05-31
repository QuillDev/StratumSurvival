package moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.AttackAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;

public abstract class BluntWeaponAttribute extends AttackAttribute {
    public BluntWeaponAttribute
            (
                    MaterialManager materialManager,
                    IKeyManager keyManager,
                    AttributeKey key,
                    Component lore,
                    float scaleValue,
                    float minRoll,
                    float maxRoll
            ) {
        super(materialManager, keyManager, key, lore, ItemLists.WEAPONS_BLUNT, scaleValue, minRoll, maxRoll);
    }
}
