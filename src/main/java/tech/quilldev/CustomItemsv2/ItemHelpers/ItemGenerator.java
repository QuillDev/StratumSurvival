package tech.quilldev.CustomItemsv2.ItemHelpers;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterialManager;
import tech.quilldev.CustomItemsv2.Attributes.Attribute;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import tech.quilldev.CustomItemsv2.Attributes.ItemAttributes;
import tech.quilldev.CustomItemsv2.MaterialManager.WeaponType;
import tech.quilldev.CustomItemsv2.ItemHelpers.ItemNames.ItemAdjectives;
import tech.quilldev.Serialization.StratumSerialization;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class ItemGenerator {

    private final static Random rand = new Random();
    private final static ItemHelper itemHelper = new ItemHelper();
    private final StratumMaterialManager materialManager;

    public ItemGenerator(StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    public ItemStack generateItem(ItemStack item, int level) {
        final var weaponType = ItemAttributes.getWeaponTypeFromItemStack(item);
        if (weaponType == null) return null;

        final var attributes = getEligibleAttributes(ItemAttributes.getAttributesOfType(weaponType.type), level);
        final var useAttributes = getUseAttributes(attributes);

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
            final var dataValue = itemHelper.generateDataValue(curAttr, level);
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

    public ItemStack generateItem(WeaponType weaponType) {
        return generateItem(weaponType, itemHelper.getRandomLevel(.38f, 6));
    }

    /**
     * Generates an item based on the given category
     *
     * @param weaponType of attributes to be generated
     * @return an item created from that type
     */
    public ItemStack generateItem(WeaponType weaponType, int level) {
        final var materials = getMaterialsFromWeaponType(weaponType, level);
        final var mat = materials.get(rand.nextInt(materials.size()));
        //Create the item
        final var item = new ItemStack(mat);
        return generateItem(item, level);
    }

    public ArrayList<ItemStack> getMaterialsFromWeaponType(WeaponType weaponType, int level) {
        final var attributes = getEligibleAttributes(ItemAttributes.getAttributesOfType(weaponType.type), level);
        return getEligibleItems(attributes);
    }


    public Component generateRandomItemName(ItemStack item) {
        final var nameCount = rand.nextInt(2) + 1;
        StringBuilder name = new StringBuilder();
        for (int index = 0; index < nameCount; index++) {
            name.append(ItemAdjectives.adjectives[rand.nextInt(ItemAdjectives.adjectives.length)]).append(" ");
        }
        final var meta = item.getItemMeta();

        if (meta.hasLocalizedName()) {
            name.append(meta.getLocalizedName());
        } else {
            name.append(item.getI18NDisplayName());
        }


        return Component.text(name.toString());
    }

    public ArrayList<Attribute> getEligibleAttributes(ArrayList<Attribute> attributes, int level) {
        return attributes.stream()
                .filter(attr -> level >= attr.getMinLevel())
                .collect(Collectors.toCollection(ArrayList::new));
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
    public WeaponType getRandomCategory() {
        final var categories = ItemAttributes.attributeCategories;
        final var keys = new ArrayList<>(categories.keySet());
        return categories.get(keys.get(rand.nextInt(keys.size())));
    }

    /**
     * Get a list of eligible materials for the current attribute list
     *
     * @param attributes to get materials from
     * @return a list of eligible materials for those attributes
     */
    public ArrayList<ItemStack> getEligibleItems(ArrayList<Attribute> attributes) {
        final var materialBuffer = new ArrayList<ItemStack>();
        final var uniqueItems = new ArrayList<ItemStack>();
        attributes.forEach(attr -> {
            materialBuffer.addAll(attr.materials);
            final var mats = attr.materials;
        });
        materialBuffer.forEach(material -> {
            if (uniqueItems.contains(material)) return;
            uniqueItems.add(material);
        });

        return uniqueItems;
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
