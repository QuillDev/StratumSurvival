package moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes;

import org.bukkit.NamespacedKey;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class ShardEpicToLegendary extends ShardRecipe {
    public ShardEpicToLegendary(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SHARD_EPIC, StratumMaterial.SHARD_LEGENDARY);
    }
}
