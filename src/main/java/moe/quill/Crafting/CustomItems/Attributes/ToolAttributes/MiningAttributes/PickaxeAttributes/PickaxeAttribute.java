package moe.quill.Crafting.CustomItems.Attributes.ToolAttributes.MiningAttributes.PickaxeAttributes;

import moe.quill.Crafting.CustomItems.Attributes.ToolAttributes.MiningAttributes.MiningAttribute;
import moe.quill.Crafting.CustomItems.Attributes.ToolAttributes.MiningAttributes.MiningEventData;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.Utils.ItemGroups;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

import java.util.ArrayList;

public abstract class PickaxeAttribute extends MiningAttribute {
    public PickaxeAttribute(NamespacedKey key, Component lore, float scaleValue, float minRoll, float maxRoll) {
        super(
                key,
                lore,
                new ArrayList<>() {{
                    addAll(ItemLists.TOOLS_PICKAXE);
                }},
                scaleValue,
                minRoll,
                maxRoll
        );
    }

    @Override
    public MiningEventData getEventData(Event sourceEvent) {
        final var sourceData = super.getEventData(sourceEvent);
        if (sourceData == null) return null;
        if (!ItemGroups.Ores.contains(sourceData.getBlock().getType())) return null;
        return sourceData;
    }
}