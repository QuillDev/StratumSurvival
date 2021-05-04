package tech.quilldev.CustomItemsv2;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

import java.util.ArrayList;

public abstract class Attribute {

    public NamespacedKey key;
    public ArrayList<Material> materials;
    //TODO: Add material types
    //TODO: See if we need to add more data types, right now assuming floats for all
    //TODO: Attributes

    public Attribute(NamespacedKey key, ArrayList<Material> materials) {
        this.key = key;
        this.materials = materials;
    }

    public abstract void execute(Event sourceEvent, float modifier);
}
