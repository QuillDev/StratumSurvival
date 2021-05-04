package tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsV1.ItemAttributes.Attribute;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class OnHitAttribute extends Attribute {
    public OnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText, PersistentDataType.FLOAT, new ArrayList<>(Arrays.asList(
                Material.WOODEN_SWORD,
                Material.WOODEN_AXE
                //TODO: ADD ON HIT ATTRIBUTE MATERIALS
                ))
        );
    }

    public abstract void execute(EntityDamageByEntityEvent event, float modifier);
}
