package moe.quill.stratumsurvival.Crafting.Items.Attributes.ToolAttributes.MiningAttributes;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class MiningEventData {

    private final BlockBreakEvent event;
    private final Player player;
    private final Block block;
    private final Collection<ItemStack> drops;

    public MiningEventData(BlockBreakEvent event, Player player, Block block, Collection<ItemStack> drops) {
        this.event = event;
        this.player = player;
        this.block = block;
        this.drops = drops;
    }

    public Player getPlayer() {
        return player;
    }

    public Block getBlock() {
        return block;
    }

    public Collection<ItemStack> getDrops() {
        return drops;
    }

    public BlockBreakEvent getEvent() {
        return event;
    }
}
