package moe.quill.stratumsurvival.Crafting.Items.Attributes.ToolAttributes.MiningAttributes.PickaxeAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.ToolAttributes.MiningAttributes.MiningAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.ToolAttributes.MiningAttributes.MiningEventData;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.stratumsurvival.Utils.ItemGroups;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;

public abstract class PickaxeAttribute extends MiningAttribute {
    public PickaxeAttribute(
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists,
            AttributeKey key,
            Component lore,
            float scaleValue,
            float minRoll,
            float maxRoll) {
        super(
                materialManager,
                keyManager,
                serializer,
                itemLists,
                key,
                lore,
                itemLists.getPickaxeItems(),
                scaleValue,
                minRoll,
                maxRoll
        );
    }

    @Override
    public MiningEventData getEventData(Event sourceEvent) {
        final var sourceData = super.getEventData(sourceEvent);
        if (sourceData == null) return null;
        if (!ItemGroups.Ore.contains(sourceData.getBlock().getType())) return null;
        return sourceData;
    }
}
