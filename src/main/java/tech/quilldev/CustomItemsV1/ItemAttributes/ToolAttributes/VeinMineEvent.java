//package tech.quilldev.CustomItems.ItemAttributes.ToolAttributes;
//
//import org.bukkit.Material;
//import org.bukkit.block.Block;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.block.BlockBreakEvent;
//import tech.quilldev.Particles.ParticleFactory;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//
//public class VeinMineEvent implements Listener {
//
//    private final static ParticleFactory particleFactory = new ParticleFactory();
//    private final static ArrayList<Material> whitelist = new ArrayList<>(Arrays.asList(
//            Material.COAL_ORE,
//            Material.IRON_ORE,
//            Material.DIAMOND_ORE,
//            Material.EMERALD_ORE,
//            Material.NETHER_GOLD_ORE,
//            Material.NETHER_QUARTZ_ORE,
//            Material.LAPIS_ORE,
//            Material.REDSTONE_ORE
//    ));
//
//    @EventHandler
//    public void handleVeinMining(BlockBreakEvent event) {
//        final var block = event.getBlock();
//        final var blockType = block.getType();
//        if (!whitelist.contains(blockType)) return; //If it's not in the whitelist, we don't care
//        final var blocks = getAllVeinMineableBlocks(block);
//        blocks.forEach(Block::breakNaturally);
//    }
//
//    public ArrayList<Block> getAllVeinMineableBlocks(Block baseBlock) {
//        var totalBlocks = new ArrayList<>(Collections.singletonList(baseBlock));
//        var lastBlocks = new ArrayList<>(Collections.singletonList(baseBlock));
//
//        for (int i = 0; i < 5; i++) {
//            final var curBlocks = new ArrayList<Block>();
//            lastBlocks.forEach(block -> curBlocks.addAll(getConnectedBlocks(block)));
//            if (curBlocks.isEmpty()) break;
//            totalBlocks.addAll(lastBlocks);
//            lastBlocks = curBlocks;
//            System.out.println(curBlocks.size());
//            System.out.println(i);
//        }
//        return totalBlocks;
//    }
//
//    public ArrayList<Block> getConnectedBlocks(Block block) {
//        final var blocks = new ArrayList<Block>();
//        for (int x = -1; x <= 1; x++) {
//            for (int y = -1; y <= 1; y++) {
//                for (int z = -1; z <= 1; z++) {
//                    if (x == 0 && y == 0 && z == 0) continue;
//                    final var curBlock = block.getRelative(x, y, z);
//                    if (!curBlock.getType().equals(block.getType())) continue;
//                    blocks.add(curBlock);
//                }
//            }
//        }
//
//        return blocks;
//    }
//}
