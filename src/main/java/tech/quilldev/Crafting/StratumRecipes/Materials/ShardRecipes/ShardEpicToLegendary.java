package tech.quilldev.Crafting.StratumRecipes.Materials.ShardRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;

public class ShardEpicToLegendary extends ShardRecipe {
    public ShardEpicToLegendary(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SHARD_EPIC, StratumMaterial.SHARD_LEGENDARY);
    }
}