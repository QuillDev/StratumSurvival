package moe.quill.stratumsurvival.Crafting.Items.Attributes.ToolAttributes.MiningAttributes;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.ToolAttributes.ToolAttribute;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public abstract class MiningAttribute extends ToolAttribute {
    public MiningAttribute(
            Plugin plugin,
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists,
            AttributeKey key,
            Component lore,
            ArrayList<ItemStack> materials,
            float scaleValue,
            float minRoll,
            float maxRoll
    ) {
        super(
                plugin,
                materialManager,
                keyManager,
                serializer,
                itemLists,
                key,
                lore,
                materials,
                scaleValue,
                minRoll,
                maxRoll,
                new ArrayList<>()
        );
    }

    public MiningEventData getEventData(Event sourceEvent) {
        if (!(sourceEvent instanceof BlockBreakEvent)) return null;
        final var event = (BlockBreakEvent) sourceEvent;
        final var player = event.getPlayer();
        final var block = event.getBlock();
        final var drops = event.getBlock().getDrops(player.getInventory().getItemInMainHand());
        return new MiningEventData(event, player, block, drops);
    }
}
