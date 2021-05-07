package tech.quilldev.CustomItemsv2.ItemGenerator;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsv2.Attribute;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.UseAttribute;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.Names.Names;
import tech.quilldev.Serialization.StratumSerialization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class ItemGenerator {

    private final static Random rand = new Random();

    /**
     * Generates an item based on the given category
     *
     * @param type of attributes to be generated
     * @return an item created from that type
     */
    public ItemStack generateItem(Class<?> type) {
        final var level = getRandomLevel(.38f, 6);
        final var attributes = getEligibleAttributes(ItemAttributes.getAttributesOfType(type), level);
        final var useAttributes = getUseAttributes(attributes);
        final var materials = getEligibleMaterials(attributes);
        final var mat = materials.get(rand.nextInt(materials.size()));

        //Create the item
        final var item = new ItemStack(mat);
        final var meta = item.getItemMeta();
        final var data = meta.getPersistentDataContainer();
        final var lore = new ArrayList<Component>();
        final var rarity = ItemRarity.getRarity(level);
        // Set the name of the item
        final var name = generateRandomItemName(item).color(rarity.getColor());
        meta.displayName(name);
        lore.add(rarity.getName());

        //Add item attributes to the item
        final var maxIndex = Math.min(attributes.size(), level);
        for (var i = 0; (i < maxIndex); i++) {
            final var curAttr = attributes.get(rand.nextInt(attributes.size()));
            final var dataValue = generateDataValue(curAttr, level);
            data.set(curAttr.key, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(dataValue));
            lore.add(curAttr.lore.append(Component.text(curAttr.dataFormat(dataValue)))); // add lore to the item
            attributes.remove(curAttr); //remove the attribute we used

            //If the attribute just added was a use attribute, make it so we can't get any more
            if (UseAttribute.class.isAssignableFrom(curAttr.getClass())) {
                attributes.removeAll(useAttributes);
            }
        }
        data.set(ItemAttributes.levelKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(level));
        data.set(ItemAttributes.nameKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeComponent(name));
        data.set(ItemAttributes.customItemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
        meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public Component generateRandomItemName(ItemStack item) {
        final var nameCount = rand.nextInt(2) + 1;
        StringBuilder name = new StringBuilder();
        for (int index = 0; index < nameCount; index++) {
            name.append(Names.adjectives[rand.nextInt(Names.adjectives.length)]).append(" ");
        }
        name.append(item.getI18NDisplayName());

        return Component.text(name.toString());
    }

    //TODO: Move these to "ItemHelper" they don't belong here!
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

    public ArrayList<Attribute> getEligibleAttributes(ArrayList<Attribute> attributes, int level) {
        return attributes.stream()
                .filter(attr -> level >= attr.getMinLevel())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private float generateDataValue(Attribute attribute, int level) {
        final var tempMax = attribute.scaleValue * level;
        final var min = attribute.minRoll;
        final var max = attribute.maxRoll;
        return (float) Math.min(Math.max((Math.random() * tempMax - min) + min, min), max);
    }

    /**
     * Get use attributes from the given list
     *
     * @param attributes to get use attributes from
     * @return a list of use attributes
     */
    public ArrayList<Attribute> getUseAttributes(ArrayList<Attribute> attributes) {
        return attributes
                .stream()
                .filter(attr -> UseAttribute.class.isAssignableFrom(attr.getClass()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Generates a completely random item based on no category restraints
     *
     * @return a completely random item
     */
    public ItemStack generateItem() {
        return generateItem(getRandomCategory());
    }

    /**
     * Get a random item category out of the ones that are registered
     *
     * @return the item category that was randomly chosen
     */
    public Class<?> getRandomCategory() {
        final var categories = ItemAttributes.attributeCategories;
        final var keys = new ArrayList<>(categories.keySet());
        return categories.get(keys.get(rand.nextInt(keys.size())));
    }

    /**
     * Get a random level for the item
     *
     * @return the level for the item
     */
    public int getRandomLevel(float levelRate, float maxLevel) {
        var level = 1;
        for (; level < maxLevel; level++) {
            if (levelRate < rand.nextFloat()) return level;
        }
        //TODO: Scale random levels (old model)
        return level;
    }

    /**
     * Get a list of eligible materials for the current attribute list
     *
     * @param attributes to get materials from
     * @return a list of eligible materials for those attributes
     */
    public ArrayList<Material> getEligibleMaterials(ArrayList<Attribute> attributes) {
        final var materialBuffer = new ArrayList<Material>();
        final var uniqueMaterials = new ArrayList<Material>();
        attributes.forEach(attr -> materialBuffer.addAll(attr.materials));
        materialBuffer.forEach(material -> {
            if (uniqueMaterials.contains(material)) return;
            uniqueMaterials.add(material);
        });

        return uniqueMaterials;
    }

    /**
     * Get the name of the item, choosing the display name first
     *
     * @param item to get the name of
     * @return the name of the item
     */
    public Component getItemName(ItemStack item) {
        final var meta = item.getItemMeta();
        final var displayName = meta.displayName();
        if (displayName == null) return Component.text(item.getI18NDisplayName());
        return displayName;
    }
}
