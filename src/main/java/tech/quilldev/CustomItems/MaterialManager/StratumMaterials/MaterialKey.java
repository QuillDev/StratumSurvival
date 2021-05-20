package tech.quilldev.CustomItems.MaterialManager.StratumMaterials;

import java.util.Arrays;

public enum MaterialKey {
    SCYTHE_KEY("itemtype_scythe"),
    BATTLEAXE_KEY("itemtype_battleaxe"),
    DAGGER_KEY("itemtype_dagger"),
    GEODE_KEY("itemtype_geode"),
    FRAGMENT_KEY("itemtype_fragment"),
    SHARD_KEY("itemtype_shard"),
    EMPTY_KEY("itemtype_none");

    public String value;

    MaterialKey(String value) {
        this.value = value;
    }

    public static MaterialKey getKeyFromValue(String value) {
        return Arrays.stream(values())
                .filter(key -> key.value.equals(value))
                .findFirst()
                .orElse(EMPTY_KEY);
    }
}
