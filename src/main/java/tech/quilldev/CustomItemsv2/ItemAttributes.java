package tech.quilldev.CustomItemsv2;

import java.util.ArrayList;

public class ItemAttributes {

    private static final ArrayList<Attribute> attributes = new ArrayList<>();

    public static void register(Attribute attribute) {
        attributes.add(attribute);
    }

    public static Attribute getAttribute(String query) {
        return attributes
                .stream()
                .filter(attr -> attr.key.value().equalsIgnoreCase(query))
                .findFirst()
                .orElse(null);
    }
}
