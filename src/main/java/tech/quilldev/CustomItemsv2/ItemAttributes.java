package tech.quilldev.CustomItemsv2;

import tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes.BluntWeaponAttribute;
import tech.quilldev.CustomItemsv2.AttackAttributes.BowWeaponAttributes.BowWeaponAttribute;
import tech.quilldev.CustomItemsv2.UseAttributes.UseAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ItemAttributes {

    private static final ArrayList<Attribute> attributes = new ArrayList<>();

    public static final HashMap<String, Class<?>> weaponCategories = new HashMap<>() {{
        put("WEAPON_BLUNT", BluntWeaponAttribute.class);
        put("WEAPON_BOW", BowWeaponAttribute.class);
    }};

    public static void register(Attribute attribute) {
        attributes.add(attribute);
    }

    public static ArrayList<Attribute> getAttributesOfType(Class<?> type) {
        return attributes
                .stream()
                .filter(attr -> type.isAssignableFrom(attr.getClass()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Attribute getAttribute(String query) {
        return attributes
                .stream()
                .filter(attr -> attr.key.value().equalsIgnoreCase(query))
                .findFirst()
                .orElse(null);
    }

    public static Class<?> getWeaponCategory(String query) {
        final var key = weaponCategories
                .keySet()
                .stream()
                .filter(weaponKey -> weaponKey.equalsIgnoreCase(query))
                .findFirst()
                .orElse("");
        return weaponCategories.get(key);
    }
}
