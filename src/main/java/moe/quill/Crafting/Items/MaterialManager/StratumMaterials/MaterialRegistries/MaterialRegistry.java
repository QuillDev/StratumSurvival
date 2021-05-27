package moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.KeyManager;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class MaterialRegistry {
    protected MaterialKey materialKey;
    protected KeyManager keyManager;

    public MaterialRegistry(KeyManager keyManager, MaterialKey materialKey) {
        this.keyManager = keyManager;
        this.materialKey = materialKey;
    }

    public abstract HashMap<String, ItemStack> getMaterials();

    public MaterialKey getMaterialKey() {
        return materialKey;
    }
}