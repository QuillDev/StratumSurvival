package moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class MaterialRegistry {
    protected MaterialKey materialKey;

    public MaterialRegistry(MaterialKey materialKey) {
        this.materialKey = materialKey;

    }

    public abstract HashMap<String, ItemStack> getMaterials();

    public MaterialKey getMaterialKey() {
        return materialKey;
    }
}