package tech.quilldev.CustomItemsv2.AttackAttributes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItemsv2.Attribute;

import java.util.ArrayList;

public abstract class AttackAttribute extends Attribute {
    public AttackAttribute(NamespacedKey key, ArrayList<Material> materials) {
        super(key, materials);
    }

    public abstract void execute(Event sourceEvent, float modifier);
}
