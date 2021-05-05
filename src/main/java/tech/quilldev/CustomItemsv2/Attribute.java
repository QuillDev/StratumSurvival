package tech.quilldev.CustomItemsv2;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.Random;

public abstract class Attribute {

    protected static final Random rand = new Random();
    public NamespacedKey key;
    public ArrayList<Material> materials;
    public Component lore;
    public float scaleValue;

    public Attribute(NamespacedKey key, Component lore, ArrayList<Material> materials, float scaleValue) {
        this.key = key;
        this.materials = materials;
        this.lore = lore;
        this.scaleValue = scaleValue;
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
