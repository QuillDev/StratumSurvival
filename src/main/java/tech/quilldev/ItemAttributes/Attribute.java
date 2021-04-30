package tech.quilldev.ItemAttributes;

import org.bukkit.NamespacedKey;
import tech.quilldev.ItemAttributes.UseAttribute.ZeusEffect;

public abstract class Attribute {


    protected NamespacedKey key;

    public Attribute(NamespacedKey key) {
        this.key = key;
    }
}
