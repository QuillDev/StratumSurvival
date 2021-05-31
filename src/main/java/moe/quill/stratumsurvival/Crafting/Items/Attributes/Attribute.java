package moe.quill.stratumsurvival.Crafting.Items.Attributes;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeHelpers.AttributeFormatter;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public abstract class Attribute {

    protected static final Random rand = new Random();
    protected static final AttributeFormatter attributeFormatter = new AttributeFormatter();

    // Item Data Attributes
    public AttributeKey key;
    public ArrayList<ItemStack> materials;
    public Component lore;
    public ArrayList<Class<?>> childAttributes;
    protected final MaterialManager materialManager;
    protected final KeyManager keyManager;
    public float minRoll;
    public float maxRoll;

    // Stats for determining item characteristics when generating the item
    public float scaleValue;

    public Attribute(
            MaterialManager materialManager,
            KeyManager keyManager,
            AttributeKey key,
            Component lore,
            ArrayList<ItemStack> items,
            float scaleValue,
            float minRoll,
            float maxRoll,
            ArrayList<Class<?>> childAttributes
    ) {
        this.materialManager = materialManager;
        this.keyManager = keyManager;
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
