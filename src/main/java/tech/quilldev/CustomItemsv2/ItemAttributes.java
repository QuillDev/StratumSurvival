package tech.quilldev.CustomItemsv2;

import tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BluntWeaponAttributes.BluntWeaponAttribute;
import tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BowWeaponAttributes.BowWeaponAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ItemAttributes {

    private static final ArrayList<Attribute> attributes = new ArrayList<>();

    public static final HashMap<String, Class<?>> itemCategories = new HashMap<>() {{
        put("WEAPON_BLUNT", BluntWeaponAttribute.class);
        put("WEAPON_BOW", BowWeaponAttribute.class);
    }};

    /**
     * Register all of the given attributes to the
     *
     * @param newAttributes the new attributes to add
     */
    public static void registerAll(Attribute... newAttributes) {
        attributes.addAll(Arrays.asList(newAttributes));
    }

    /**
     * Get all attributes of the given class type
     *
     * @param type of attributes to get.
     * @return an arraylist of attributes matching the given type
     */
    public static ArrayList<Attribute> getAttributesOfType(Class<?> type) {
        final var attributeList = new ArrayList<Attribute>();

        //Get all attributes and their children that are eligible to be added from this class
        attributes.forEach((attr) -> {
            if (!(type.isAssignableFrom(attr.getClass()))) return;
            attributeList.add(attr);
            attr.childAttributes.forEach((child) -> {
                attributeList.addAll(getAttributesOfType(child));
            });
        });

        return attributeList;
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
        final var key = itemCategories
                .keySet()
                .stream()
                .filter(weaponKey -> weaponKey.equalsIgnoreCase(query))
                .findFirst()
                .orElse("");
        return itemCategories.get(key);
    }
}
