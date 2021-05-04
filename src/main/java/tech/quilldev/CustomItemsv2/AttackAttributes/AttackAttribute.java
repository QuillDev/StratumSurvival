package tech.quilldev.CustomItemsv2.AttackAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItemsv2.Attribute;

import java.util.ArrayList;

public abstract class AttackAttribute extends Attribute {
    public AttackAttribute(NamespacedKey key, Component lore, ArrayList<Material> materials) {
        super(key, lore, materials);
    }

    public abstract void execute(Event sourceEvent, float modifier);
}
