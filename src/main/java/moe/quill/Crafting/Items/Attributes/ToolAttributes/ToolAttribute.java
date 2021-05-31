package moe.quill.Crafting.Items.Attributes.ToolAttributes;

import moe.quill.Crafting.Items.Attributes.Attribute;
import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public abstract class ToolAttribute extends Attribute {
    public ToolAttribute(MaterialManager materialManager, KeyManager keyManager, AttributeKey key,
                         Component lore,
                         ArrayList<ItemStack> items,
                         float scaleValue,
                         float minRoll,
                         float maxRoll,
                         ArrayList<Class<?>> childAttributes
    ) {
        super(materialManager, keyManager, key, lore, items, scaleValue, minRoll, maxRoll, childAttributes);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {

    }
}
