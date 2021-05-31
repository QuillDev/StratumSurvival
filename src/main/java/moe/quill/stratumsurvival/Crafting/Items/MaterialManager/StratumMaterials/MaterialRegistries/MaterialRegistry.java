package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class MaterialRegistry {
    protected MaterialKey materialKey;
    protected IKeyManager keyManager;

    public MaterialRegistry(IKeyManager keyManager, MaterialKey materialKey) {
        this.keyManager = keyManager;
        this.materialKey = materialKey;
    }

    public abstract HashMap<String, ItemStack> getMaterials();

    public MaterialKey getMaterialKey() {
        return materialKey;
    }
}