package tech.quilldev.ItemAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;

import java.util.Random;


public abstract class Attribute {

    public final Random rand = new Random();
    public final NamespacedKey key;
    public final Component displayText;

    public Attribute(NamespacedKey key, Component displayText) {
        this.key = key;
        this.displayText = displayText;
    }
}
