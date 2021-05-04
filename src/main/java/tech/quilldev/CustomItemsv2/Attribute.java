package tech.quilldev.CustomItemsv2;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

import java.util.ArrayList;

public abstract class Attribute {

    public NamespacedKey key;
    public ArrayList<Material> materials;
    public Component lore;
    //TODO: Add material types
    //TODO: See if we need to add more data types, right now assuming floats for all
    //TODO: Attributes

    public Attribute(NamespacedKey key, Component lore, ArrayList<Material> materials) {
        this.key = key;
        this.materials = materials;
        this.lore = lore;
    }

    public abstract void execute(Event sourceEvent, float modifier);
}
