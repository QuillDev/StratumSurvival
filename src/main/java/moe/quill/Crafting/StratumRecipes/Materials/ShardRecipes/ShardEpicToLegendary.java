package moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes;

import moe.quill.Crafting.RecipeKey;
import org.bukkit.NamespacedKey;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class ShardEpicToLegendary extends ShardRecipe {
    public ShardEpicToLegendary(StratumMaterialManager materialManager) {
        super(RecipeKey.SHARD_EPIC_TO_LEGENDARY, materialManager, StratumMaterial.SHARD_EPIC, StratumMaterial.SHARD_LEGENDARY);
    }
}
