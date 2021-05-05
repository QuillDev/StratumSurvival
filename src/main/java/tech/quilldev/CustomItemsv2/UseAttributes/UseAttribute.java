package tech.quilldev.CustomItemsv2.UseAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItemsv2.Attribute;

import java.util.ArrayList;

public class UseAttribute extends Attribute {
    public UseAttribute(NamespacedKey key, Component lore, float scaleValue) {
        super(key, lore, new ArrayList<>(), scaleValue);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {

    }
}
