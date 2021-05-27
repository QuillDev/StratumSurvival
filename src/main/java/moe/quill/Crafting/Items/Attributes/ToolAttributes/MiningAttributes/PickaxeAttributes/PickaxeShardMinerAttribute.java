package moe.quill.Crafting.Items.Attributes.ToolAttributes.MiningAttributes.PickaxeAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.ItemHelpers.ItemHelper;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

import java.util.HashMap;

@SuppressWarnings("unused")
public class PickaxeShardMinerAttribute extends PickaxeAttribute {
    private final ItemHelper itemHelper;

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

    public PickaxeShardMinerAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(materialManager, keyManager, AttributeKey.PICKAXE_SHARD_MINER_ATTRIBUTE, Component.text("Fragment Finder").color(TextColor.color(0x32A2CB)), .5f, 1, 3);
        this.itemHelper = new ItemHelper(keyManager);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;
        final var player = eventData.getPlayer();
        final var block = eventData.getBlock();

        //Get the level of the block
        final var level = itemHelper.getRandomLevel(.38f, 6);
        final var odds = oreOdds.get(block.getType());
        if (odds == null) return;

        //Get the fragment + drop it if we have a good roll
        if (odds < rand.nextFloat()) return;
        final var fragment = materialManager.getFragmentForLevel(level);
        final var drop = fragment.clone();
        drop.setAmount((int) Math.floor(modifier));
        player.getWorld().dropItemNaturally(block.getLocation(), drop);
        player.sendActionBar(Component.text("Your pickaxe managed to find some shards!"));
    }

    @Override
    public String dataFormat(float data) {
        return attributeFormatter.formatFloat((int) Math.floor(data));
    }
}
