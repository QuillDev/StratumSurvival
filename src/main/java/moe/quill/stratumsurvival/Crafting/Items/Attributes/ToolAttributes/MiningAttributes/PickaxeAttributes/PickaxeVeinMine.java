package moe.quill.stratumsurvival.Crafting.Items.Attributes.ToolAttributes.MiningAttributes.PickaxeAttributes;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.stratumsurvival.Utils.ItemGroups;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("unused")
public class PickaxeVeinMine extends PickaxeAttribute {
    public PickaxeVeinMine(
            Plugin plugin,
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists
    ) {
        super(
                plugin,
                materialManager,
                keyManager,
                serializer,
                itemLists,
                AttributeKey.PICKAXE_VEIN_MINER_ATTRIBUTE,
                Component.text("Vein Miner"),
                1.5f,
                3,
                8
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var stack = new ItemStack(Material.DIAMOND_PICKAXE);
        //Get data about the current event
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;
        final var block = eventData.getBlock();
        final var blockType = block.getType();
        if (!ItemGroups.Ore.contains(blockType)) return; //If it's not in the whitelist, we don't care

        //Actually process the vein mining
        final var range = (int) modifier + 1;
        final var blocks = getAllVeinMineableBlocks(block, range);
        final var usableBlocks = blocks.subList(0, Math.min(blocks.size(), range));
        usableBlocks.forEach(blockToBreak -> blockToBreak.breakNaturally(eventData.getPlayer().getInventory().getItemInMainHand()));
    }

    public ArrayList<Block> getAllVeinMineableBlocks(Block baseBlock, int range) {
        var totalBlocks = new ArrayList<>(Collections.singletonList(baseBlock));
        var lastBlocks = new ArrayList<>(Collections.singletonList(baseBlock));

        for (int i = 0; i < range; i++) {
            final var curBlocks = new ArrayList<Block>();
            lastBlocks.forEach(block -> curBlocks.addAll(getConnectedBlocks(block)));
            if (curBlocks.isEmpty()) break;
            totalBlocks.addAll(lastBlocks);
            lastBlocks = curBlocks;
        }
        return totalBlocks;
    }

    public ArrayList<Block> getConnectedBlocks(Block block) {
        final var blocks = new ArrayList<Block>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (x == 0 && y == 0 && z == 0) continue;
                    final var curBlock = block.getRelative(x, y, z);
                    if (!curBlock.getType().equals(block.getType())) continue;
                    blocks.add(curBlock);
                }
            }
        }

        return blocks;
    }

    @Override
    public String dataFormat(float data) {
        return attributeFormatter.formatFloat((int) Math.floor(data)) + " Range";
    }
}
