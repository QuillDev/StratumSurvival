package moe.quill.Crafting.Items.Attributes;

import moe.quill.Crafting.Items.Attributes.ToolAttributes.MiningAttributes.PickaxeAttributes.PickaxeAttribute;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import moe.quill.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes.BluntWeaponAttribute;
import moe.quill.Crafting.Items.Attributes.AttackAttributes.BowWeaponAttributes.BowWeaponAttribute;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemType;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ItemAttributes {

    //Public keys
    public static NamespacedKey levelKey = null;
    public static NamespacedKey obfuscatedKey = null;
    public static NamespacedKey nameKey = null;
    public static NamespacedKey customItemKey = null;
    public static NamespacedKey cooldownKey;

    //Trinket Keys
    public static NamespacedKey inventorySizeKey = null;
    public static NamespacedKey inventoryItemDataKey = null;

    //list of attributes
    private static final ArrayList<Attribute> attributes = new ArrayList<>();
    private static final Reflections reflections = new Reflections("moe.quill");
    private static final Logger logger = LoggerFactory.getLogger(ItemAttributes.class.getSimpleName());

    //Attribute categories
    public static final HashMap<String, ItemType> attributeCategories = new HashMap<>();

    public ItemAttributes(Plugin plugin) {
        levelKey = new NamespacedKey(plugin, "item_level");
        obfuscatedKey = new NamespacedKey(plugin, "item_obfuscated");
        nameKey = new NamespacedKey(plugin, "item_name");
        customItemKey = new NamespacedKey(plugin, "item_is_custom");
        cooldownKey = new NamespacedKey(plugin, "item_use_cooldown");
        inventorySizeKey = new NamespacedKey(plugin, "inventory_size");
        inventoryItemDataKey = new NamespacedKey(plugin, "inventory_data");
    }

    public void init(Plugin plugin) {
        attributeCategories.putIfAbsent("WEAPON_BLUNT", new ItemType(ItemLists.WEAPONS_BLUNT, BluntWeaponAttribute.class));
        attributeCategories.putIfAbsent("WEAPON_BOW", new ItemType(ItemLists.WEAPONS_BOW, BowWeaponAttribute.class));
        attributeCategories.putIfAbsent("TOOLS_PICKAXE", new ItemType(ItemLists.TOOLS_PICKAXE, PickaxeAttribute.class));
        dynamicallyLoadAttributes(plugin);

    }

    /**
     * Attempt do dynamically load attributes based on their extension from the attribute class
     *
     * @param plugin to create namespaced keys for
     */
    private void dynamicallyLoadAttributes(Plugin plugin) {
        reflections
                .getSubTypesOf(Attribute.class)
                .stream()
                .filter(attrClass -> !Modifier.isAbstract(attrClass.getModifiers()))
                .forEach(attrClass -> {
                    try {
                        final var attr = attrClass.getDeclaredConstructor().newInstance();
                        ItemAttributes.registerAll(attr);
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * Register all of the given attributes to the
     *
     * @param newAttributes the new attributes to add
     */
    public static void registerAll(Attribute... newAttributes) {
        attributes.addAll(Arrays.asList(newAttributes));
        //Log the attributes that we just loaded
        Arrays.stream(newAttributes).forEach(attr -> {
            logger.info(String.format("Loaded attribute %s [key:%s]", attr.getClass().getSimpleName(), attr.key.name()));
        });
    }

    /**
     * Get all attributes of the given class type
     *
     * @param type of attributes to get.
     * @return an arraylist of attributes matching the given type
     */
    public static ArrayList<Attribute> getAttributesOfType(Class<?> type) {
        final var attributeList = new ArrayList<Attribute>();
        final var uniqueList = new ArrayList<Attribute>();
        //Get all attributes and their children that are eligible to be added from this class
        attributes.forEach((attr) -> {
            if (!(type.isAssignableFrom(attr.getClass()))) return;
            attributeList.add(attr);
            attr.childAttributes.forEach((child) -> {
                attributeList.addAll(getAttributesOfType(child));
            });
        });

        //Get only unique attributes
        attributeList.forEach(attr -> {
            if (uniqueList.contains(attr)) return;
            uniqueList.add(attr);
        });

        return uniqueList;
    }

    /**
     * Get the attribute with the given key
     *
     * @param query to search for attributes that match it
     * @return a matching attribute
     */
    public static Attribute getAttribute(AttributeKey query) {
        return attributes
                .stream()
                .filter(attr -> attr.key.equals(query))
                .findFirst()
                .orElse(null);
    }

    /**
     * Get the item category matching the given query
     *
     * @param query to match with the category
     * @return the weapon category for the given string
     */
    public static ItemType getWeaponCategory(String query) {
        final var key = attributeCategories
                .keySet()
                .stream()
                .filter(weaponKey -> weaponKey.equalsIgnoreCase(query))
                .findFirst()
                .orElse("");
        return attributeCategories.get(key);
    }

    public static ItemType getWeaponTypeFromItemStack(ItemStack queryStack) {

        for (final var key : attributeCategories.keySet()) {
            //Get the current entry
            final var entry = attributeCategories.get(key);

            //Loop through the item list
            for (final var item : entry.itemStacks) {
                //If the item is the same as the query stack, return it
                if (!item.equals(queryStack)) continue;
                return entry;
            }
        }

        //Otherwise return nothing
        return null;
    }
}
