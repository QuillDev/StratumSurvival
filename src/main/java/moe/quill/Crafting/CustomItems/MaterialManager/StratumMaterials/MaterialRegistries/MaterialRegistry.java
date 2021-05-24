package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialKey;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class MaterialRegistry {
    protected MaterialKey materialKey;

    public MaterialRegistry(MaterialKey materialKey) {
        this.materialKey = materialKey;

    }

    public abstract HashMap<String, ItemStack> getMaterials(NamespacedKey key);

    public MaterialKey getMaterialKey() {
        return materialKey;
    }
}