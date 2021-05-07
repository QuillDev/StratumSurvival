package tech.quilldev.CustomItemsv2;

import net.kyori.adventure.key.Namespaced;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BluntWeaponAttributes.BluntWeaponAttribute;
import tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BowWeaponAttributes.BowWeaponAttribute;
import tech.quilldev.StratumSurvival;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ItemAttributes {

    //Public keys
    public static NamespacedKey levelKey = null;
    public static NamespacedKey obfuscatedKey = null;
    public static NamespacedKey nameKey = null;
    public static NamespacedKey customItemKey = null;

    //list of attributes
    private static final ArrayList<Attribute> attributes = new ArrayList<>();

    //Attribute categories
    public static final HashMap<String, Class<?>> attributeCategories = new HashMap<>() {{
        put("WEAPON_BLUNT", BluntWeaponAttribute.class);
        put("WEAPON_BOW", BowWeaponAttribute.class);
    }};

    public static void init(Plugin plugin) {
        levelKey = new NamespacedKey(plugin, "item_level");
        obfuscatedKey = new NamespacedKey(plugin, "item_obfuscated");
        nameKey = new NamespacedKey(plugin, "item_name");
        customItemKey = new NamespacedKey(plugin, "item_is_custom");
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
            StratumSurvival.log(ItemAttributes.class, "Loaded attribute " + attr.key.getKey() + "!");
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
    public static Attribute getAttribute(String query) {
        return attributes
                .stream()
                .filter(attr -> attr.key.value().equalsIgnoreCase(query))
                .findFirst()
                .orElse(null);
    }

    /**
     * Get the item category matching the given query
     *
     * @param query to match with the category
     * @return the weapon category for the given string
     */
    public static Class<?> getWeaponCategory(String query) {
        final var key = attributeCategories
                .keySet()
                .stream()
                .filter(weaponKey -> weaponKey.equalsIgnoreCase(query))
                .findFirst()
                .orElse("");
        return attributeCategories.get(key);
    }
}
