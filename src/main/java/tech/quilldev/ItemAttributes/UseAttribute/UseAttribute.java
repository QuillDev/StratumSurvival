package tech.quilldev.ItemAttributes.UseAttribute;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import tech.quilldev.ItemAttributes.Attribute;

public abstract class UseAttribute extends Attribute {

    public NamespacedKey key;

    public UseAttribute(NamespacedKey key) {
        super(key);
        this.key = key;
    }

    public abstract void execute(Player player);
}
