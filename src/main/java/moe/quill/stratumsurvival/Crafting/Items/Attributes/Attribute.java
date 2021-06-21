package moe.quill.stratumsurvival.Crafting.Items.Attributes;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeHelpers.AttributeFormatter;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Random;

public abstract class Attribute {

    protected static final Random rand = new Random();
    protected static final AttributeFormatter attributeFormatter = new AttributeFormatter();

    // Item Data Attributes
    protected final Plugin plugin;
    protected final MaterialManager materialManager;
    protected final IKeyManager keyManager;
    protected final ISerializer serializer;
    protected final ItemLists itemLists;

    public AttributeKey key;
    public ArrayList<ItemStack> materials;
    public Component lore;
    public ArrayList<Class<?>> childAttributes;

    public float minRoll;
    public float maxRoll;

    // Stats for determining item characteristics when generating the item
    public float scaleValue;

    public Attribute(
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
        this.plugin = plugin;
        this.materialManager = materialManager;
        this.keyManager = keyManager;
        this.serializer = serializer;
        this.itemLists = itemLists;
        this.key = key;
        this.materials = items;
        this.lore = lore;
        this.scaleValue = scaleValue;
        this.childAttributes = childAttributes;
        this.minRoll = minRoll;
        this.maxRoll = maxRoll;
    }

    /**
     * Get the minimum level the attribute can appear at
     *
     * @return get the minimum level for this enchantment
     */
    public int getMinLevel() {
        return 0;
    }

    /**
     * How we want to format the data from the item roll
     *
     * @param data to format
     * @return the data after it has been formatted
     */
    public String dataFormat(float data) {
        return "";
    }

    public abstract void execute(Event sourceEvent, float modifier);
}
