package tech.quilldev.CustomItemsv2;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.Random;

public abstract class Attribute {

    protected static final Random rand = new Random();

    // Item Data Attributes
    public NamespacedKey key;
    public ArrayList<Material> materials;
    public Component lore;
    public ArrayList<Class<?>> childAttributes;
    public float minRoll;
    public float maxRoll;

    // Stats for determining item characteristics when generating the item
    public float scaleValue;

    public Attribute(NamespacedKey key,
                     Component lore,
                     ArrayList<Material> materials,
                     float scaleValue,
                     float minRoll,
                     float maxRoll,
                     ArrayList<Class<?>> childAttributes
    ) {
        this.key = key;
        this.materials = materials;
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
