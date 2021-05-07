package tech.quilldev.CustomItemsv2.ItemHelpers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsv2.Attribute;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.Serialization.StratumSerialization;

import java.util.ArrayList;
import java.util.Collections;

public class ItemHelper {

    public void rerollItem(ItemStack item) {
        final var meta = item.getItemMeta();
        final var data = meta.getPersistentDataContainer();
        data.getKeys().forEach((key) -> {
            final var attribute = ItemAttributes.getAttribute(key.getKey());

            //Get the level of the item
            final var levelBytes = data.get(ItemAttributes.levelKey, PersistentDataType.BYTE_ARRAY);
            var level = (int) StratumSerialization.deserializeFloat(levelBytes);

            if (attribute == null) return;
            final var dataValue = generateDataValue(attribute, level);
            data.set(attribute.key, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(dataValue));
            setLoreFromItemKeys(meta);
            item.setItemMeta(meta);
        });
    }

    public float generateDataValue(Attribute attribute, int level) {
        final var tempMax = attribute.scaleValue * level;
        final var min = attribute.minRoll;
        final var max = attribute.maxRoll;
        return (float) Math.min(Math.max((Math.random() * tempMax - min) + min, min), max);
    }

    public void setLoreFromItemKeys(ItemMeta meta) {
        final var data = meta.getPersistentDataContainer();
        if (data.getKeys().size() == 0) return;
        final var lore = new ArrayList<Component>();
        final var level = (int) StratumSerialization.deserializeFloat(data.get(ItemAttributes.levelKey, PersistentDataType.BYTE_ARRAY));
        lore.add(ItemRarity.getRarity(level).getName());
        for (final var key : data.getKeys()) {
            final var attr = ItemAttributes.getAttribute(key.getKey());
            if (attr == null) continue;
            //Get the value off of the item for the given attribute
            final var valueBytes = data.get(attr.key, PersistentDataType.BYTE_ARRAY);
            final var value = StratumSerialization.deserializeFloat(valueBytes);
            if (Float.isNaN(value)) continue;
            lore.add(attr.lore.append(Component.text(attr.dataFormat(value))));
        }
        meta.lore(lore);
    }

    public void decryptItem(ItemStack itemStack) {
        final var meta = itemStack.getItemMeta();
        setLoreFromItemKeys(meta);
        final var data = meta.getPersistentDataContainer();
        if (data.getKeys().size() == 0) return;
        data.remove(ItemAttributes.obfuscatedKey);
        if (data.has(ItemAttributes.nameKey, PersistentDataType.BYTE_ARRAY)) {
            final var nameBytes = data.get(ItemAttributes.nameKey, PersistentDataType.BYTE_ARRAY);
            final var name = StratumSerialization.deserializeComponent(nameBytes);
            meta.displayName(name);
        }
        itemStack.setItemMeta(meta);
    }

    public void encryptItem(ItemStack itemStack) {
        final var meta = itemStack.getItemMeta();
        meta.lore(Collections.singletonList(Component.text("????????").decorate(TextDecoration.OBFUSCATED)));
        meta.displayName(Component.text("?????????").decorate(TextDecoration.OBFUSCATED));
        final var data = meta.getPersistentDataContainer();
        data.set(ItemAttributes.obfuscatedKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
        itemStack.setItemMeta(meta);
    }
}
