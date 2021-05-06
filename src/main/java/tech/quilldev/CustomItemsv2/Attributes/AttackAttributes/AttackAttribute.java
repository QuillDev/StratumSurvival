package tech.quilldev.CustomItemsv2.Attributes.AttackAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItemsv2.Attribute;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.UseAttribute;

import java.util.ArrayList;
import java.util.Collections;

public abstract class AttackAttribute extends Attribute {
    public AttackAttribute(NamespacedKey key, Component lore, ArrayList<Material> materials, float scaleValue, float minRoll, float maxRoll) {
        super(
                key,
                lore,
                materials,
                scaleValue,
                minRoll,
                maxRoll,
                new ArrayList<>(Collections.singletonList(
                        UseAttribute.class
                )));
    }

    public abstract void execute(Event sourceEvent, float modifier);
}
