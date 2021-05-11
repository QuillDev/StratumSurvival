package tech.quilldev.CustomItemsv2.Attributes.AttackAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import tech.quilldev.CustomItemsv2.Attributes.Attribute;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.UseAttribute;

import java.util.ArrayList;
import java.util.Collections;

public abstract class AttackAttribute extends Attribute {
    public AttackAttribute(NamespacedKey key, Component lore, ArrayList<ItemStack> itemStacks, float scaleValue, float minRoll, float maxRoll) {
        super(
                key,
                lore,
                itemStacks,
                scaleValue,
                minRoll,
                maxRoll,
                new ArrayList<>(Collections.singletonList(
                        UseAttribute.class
                )));
    }

    public abstract void execute(Event sourceEvent, float modifier);
}
