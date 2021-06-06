package moe.quill.stratumsurvival.Crafting.Items.Attributes.ToolAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.Attribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public abstract class ToolAttribute extends Attribute {
    public ToolAttribute(
            Plugin plugin,
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists,
            AttributeKey key,
            Component lore,
            ArrayList<ItemStack> items,
            float scaleValue,
            float minRoll,
            float maxRoll,
            ArrayList<Class<?>> childAttributes
    ) {
        super(
                plugin,
                materialManager,
                keyManager,
                serializer,
                itemLists,
                key,
                lore,
                items,
                scaleValue,
                minRoll,
                maxRoll,
                childAttributes);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {

    }
}
