package tech.quilldev.CustomItemsV1.ItemAttributes.OnUseAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsV1.ItemAttributes.Attribute;

import java.util.ArrayList;
import java.util.Collections;

public abstract class OnUseAttribute extends Attribute {

    public OnUseAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText, PersistentDataType.STRING,
                new ArrayList<>(Collections.singletonList(Material.GOLDEN_AXE)) //TODO: ADD USE ITEM MATERIAL
        );
    }

    public abstract void execute(Player player);
}
