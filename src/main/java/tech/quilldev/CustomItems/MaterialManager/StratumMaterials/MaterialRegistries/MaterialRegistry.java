package tech.quilldev.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class MaterialRegistry {
    protected NamespacedKey itemKey;

    public MaterialRegistry(NamespacedKey itemKey) {
        this.itemKey = itemKey;

    }

    public abstract HashMap<String, ItemStack> getMaterials();

    public NamespacedKey getItemKey() {
        return itemKey;
    }
}