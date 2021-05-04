package tech.quilldev.CustomItemsV1.ItemAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Random;


public abstract class Attribute {

    public final Random rand = new Random();
    public final NamespacedKey key;
    public final Component displayText;
    public final PersistentDataType dataType;
    public final ArrayList<Material> materials;

    public Attribute(NamespacedKey key, Component displayText, PersistentDataType dataType, ArrayList<Material> materials) {
        this.key = key;
        this.displayText = displayText;
        this.dataType = dataType;
        this.materials = materials;
    }
}
