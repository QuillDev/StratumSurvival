package tech.quilldev.ItemAttributes.DamageAttribute;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import tech.quilldev.ItemAttributes.Attribute;

public abstract class DamageAttribute extends Attribute {
    public DamageAttribute(NamespacedKey key) {
        super(key);
    }

    public abstract void execute(Player player, Entity target);
}
