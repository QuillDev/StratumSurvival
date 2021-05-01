package tech.quilldev.ItemAttributes.UseAttribute;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import tech.quilldev.ItemAttributes.Attribute;

public abstract class UseAttribute extends Attribute {

    public UseAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    public abstract void execute(Player player);
}
