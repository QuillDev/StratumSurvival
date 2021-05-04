package tech.quilldev.CustomItemsV1.ItemAttributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsV1.ItemAttributes.Attribute;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class OnDeathAttribute extends Attribute {
    public OnDeathAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText, PersistentDataType.STRING,
                new ArrayList<>(Arrays.asList(
                        Material.WOODEN_SWORD,
                        Material.WOODEN_AXE
                        //TODO: ADD ON DEATH ATTRIBUTE MATERIALS
                )));
    }

    public abstract void execute(EntityDeathEvent deathEvent);
}
