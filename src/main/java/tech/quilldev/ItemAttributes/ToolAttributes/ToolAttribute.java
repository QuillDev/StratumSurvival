package tech.quilldev.ItemAttributes.ToolAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.ItemAttributes.Attribute;

import java.util.ArrayList;

public abstract class ToolAttribute extends Attribute {

    public ToolAttribute(NamespacedKey key, Component displayText, ArrayList<Material> materials) {
        super(key, displayText, PersistentDataType.STRING, materials);
    }

    public abstract void execute(BlockBreakEvent event);
}
