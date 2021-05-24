package moe.quill.Crafting.CustomItems.Attributes.ToolAttributes.MiningAttributes;

import moe.quill.Crafting.CustomItems.Attributes.ToolAttributes.ToolAttribute;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public abstract class MiningAttribute extends ToolAttribute {
    public MiningAttribute(
            NamespacedKey key,
            Component lore,
            ArrayList<ItemStack> materials,
            float scaleValue,
            float minRoll,
            float maxRoll
    ) {
        super(key,
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
