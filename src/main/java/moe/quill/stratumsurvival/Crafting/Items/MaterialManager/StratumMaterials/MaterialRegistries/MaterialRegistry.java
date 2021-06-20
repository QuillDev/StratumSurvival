package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class MaterialRegistry {
    protected MaterialKey materialKey;
    protected IKeyManager keyManager;
    protected ISerializer serializer;

    public MaterialRegistry(IKeyManager keyManager, ISerializer serializer, MaterialKey materialKey) {
        this.keyManager = keyManager;
        this.materialKey = materialKey;
        this.serializer = serializer;
    }

    public abstract HashMap<String, ItemStack> getMaterials();

    public MaterialKey getMaterialKey() {
        return materialKey;
    }
}