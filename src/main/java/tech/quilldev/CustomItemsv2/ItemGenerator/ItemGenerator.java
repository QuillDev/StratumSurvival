package tech.quilldev.CustomItemsv2.ItemGenerator;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsv2.Attribute;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.CustomItemsv2.UseAttributes.UseAttribute;
import tech.quilldev.Serialization.StratumSerialization;

import java.util.ArrayList;
import java.util.Random;

public class ItemGenerator {

    private final static Random rand = new Random();

    /**
     * Generates an item based on the given category
     *
     * @param type of attributes to be generated
     * @return an item created from that type
     */
    public ItemStack generateItem(Class<?> type) {
        final var attributes = ItemAttributes.getAttributesOfType(type);
        final var materials = getEligibleMaterials(attributes);
        final var mat = materials.get(rand.nextInt(materials.size()));
        final var level = getRandomLevel(.38f, 6); //TODO: Change back to .38f
        //If the item is level 4+ it can have use attributes
        if (level >= 4) {
            attributes.addAll(ItemAttributes.getAttributesOfType(UseAttribute.class));
        }
        //Create the item
        final var item = new ItemStack(mat);
        final var meta = item.getItemMeta();
        final var data = meta.getPersistentDataContainer();
        final var lore = new ArrayList<Component>();
        lore.add(Component.text("Level: " + level)); //TODO: Map levels to cool text components

        //Add item attributes to the item
        final var maxIndex = Math.min(attributes.size(), level);
        for (var i = 0; (i < maxIndex); i++) {
            final var curAttr = attributes.get(rand.nextInt(attributes.size()));
            final var dataValue = generateDataValue(curAttr, level);
            data.set(curAttr.key, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(dataValue));
            lore.add(curAttr.lore.append(Component.text(curAttr.dataFormat(dataValue)))); // add lore to the item
            attributes.remove(curAttr); //remove the attribute we used
        }
        meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }

    private float generateDataValue(Attribute attribute, int level) {
        final var maxValue = attribute.scaleValue * level;
        final var minValue = Math.max(attribute.scaleValue * .1f, .1f);
        final var value = (rand.nextFloat() * (maxValue - minValue)) + minValue;
        return Math.round(value * 10) / 10.f;
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
        final var categories = ItemAttributes.weaponCategories;
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
}