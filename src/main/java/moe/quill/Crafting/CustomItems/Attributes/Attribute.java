package moe.quill.Crafting.CustomItems.Attributes;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import moe.quill.Crafting.CustomItems.Attributes.AttributeHelpers.AttributeFormatter;

import java.util.ArrayList;
import java.util.Random;

public abstract class Attribute {

    protected static StratumMaterialManager materialManager;
    protected static final Random rand = new Random();
    protected static final AttributeFormatter attributeFormatter = new AttributeFormatter();

    // Item Data Attributes
    public NamespacedKey key;
    public ArrayList<ItemStack> materials;
    public Component lore;
    public ArrayList<Class<?>> childAttributes;
    public float minRoll;
    public float maxRoll;

    // Stats for determining item characteristics when generating the item
    public float scaleValue;

    public Attribute(NamespacedKey key,
                     Component lore,
                     ArrayList<ItemStack> items,
                     float scaleValue,
                     float minRoll,
                     float maxRoll,
                     ArrayList<Class<?>> childAttributes
    ) {
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

    /**
     * Set the material manager for all attributes
     *
     * @param materialManager to set
     */
    public static void setMaterialManager(StratumMaterialManager materialManager) {
        Attribute.materialManager = materialManager;
    }

    public abstract void execute(Event sourceEvent, float modifier);
}