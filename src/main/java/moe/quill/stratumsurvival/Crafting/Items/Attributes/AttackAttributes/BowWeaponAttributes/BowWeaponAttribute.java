package moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BowWeaponAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.Attribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.OnDeathAttributes.OnDeathAttribute;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.Collections;

public abstract class BowWeaponAttribute extends Attribute {

    protected final BowAttributeMethods bowAttributeMethods = new BowAttributeMethods();

    public BowWeaponAttribute(MaterialManager materialManager, IKeyManager keyManager, AttributeKey key, Component lore, float scaleValue, float minRoll, float maxRoll) {
        super(materialManager, keyManager, key, lore, ItemLists.WEAPONS_BOW, scaleValue, minRoll, maxRoll, new ArrayList<>(
                Collections.singletonList(OnDeathAttribute.class)
        ));
    }
}
