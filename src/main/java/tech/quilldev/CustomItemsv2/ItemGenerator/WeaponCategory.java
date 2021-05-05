package tech.quilldev.CustomItemsv2.ItemGenerator;

public class WeaponCategory {

    private final String name;
    private final Class<?> type;

    public WeaponCategory(String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Class<?> getType() {
        return type;
    }
}
