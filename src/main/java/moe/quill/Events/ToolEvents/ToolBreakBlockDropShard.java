package moe.quill.Events.ToolEvents;

import moe.quill.StratumSurvival;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import moe.quill.Crafting.CustomItems.ItemHelpers.ItemHelper;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

import java.util.HashMap;
import java.util.Random;

public class ToolBreakBlockDropShard implements Listener {

    private final StratumMaterialManager materialManager;
    private final ItemHelper itemHelper = new ItemHelper();
    private final Random rand = StratumSurvival.rand;

    private final static float rareOdds = 1 / 300f;
    private final static float normalOdds = 1 / 100f;
    private final static float commonOdds = 1 / 25f;

    //Create an odds map for the given materials and float
    private final static HashMap<Material, Float> oreOdds = new HashMap<>() {{
        put(Material.REDSTONE_ORE, rareOdds);
        put(Material.LAPIS_ORE, rareOdds);
        put(Material.NETHER_QUARTZ_ORE, rareOdds);
        put(Material.COAL_ORE, rareOdds);
        put(Material.IRON_ORE, normalOdds);
        put(Material.GOLD_ORE, normalOdds);
        put(Material.NETHER_GOLD_ORE, normalOdds);
        put(Material.DIAMOND_ORE, commonOdds);
        put(Material.EMERALD_ORE, commonOdds);
    }};

    public ToolBreakBlockDropShard(StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    //TODO: Add odds to this
    @EventHandler
    public void dropShardOnBlockBreak(BlockBreakEvent event) {
        if (!event.isDropItems()) return;
        final var player = event.getPlayer();
        final var block = event.getBlock();

        //Get the level of the block
        final var level = itemHelper.getRandomLevel(.38f, 6);
        final var odds = oreOdds.get(block.getType());
        if (odds == null) return;

        //Get the fragment + drop it if we have a good roll
        if (odds < rand.nextFloat()) return;
        final var fragment = materialManager.getFragmentForLevel(level);
        player.getWorld().dropItemNaturally(block.getLocation(), fragment);
    }
}
