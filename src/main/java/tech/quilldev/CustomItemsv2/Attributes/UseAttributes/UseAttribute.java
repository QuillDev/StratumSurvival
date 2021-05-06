package tech.quilldev.CustomItemsv2.Attributes.UseAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItemsv2.Attribute;

import java.util.ArrayList;

public abstract class UseAttribute extends Attribute {
    public UseAttribute(NamespacedKey key, Component lore, float scaleValue) {
        super(key, lore, new ArrayList<>(), scaleValue, new ArrayList<>());
    }
}
