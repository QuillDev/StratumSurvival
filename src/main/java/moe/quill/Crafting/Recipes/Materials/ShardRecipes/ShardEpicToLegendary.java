package moe.quill.Crafting.Recipes.Materials.ShardRecipes;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.RecipeKey;

public class ShardEpicToLegendary extends ShardRecipe {
    public ShardEpicToLegendary(MaterialManager materialManager) {
        super(RecipeKey.SHARD_EPIC_TO_LEGENDARY, materialManager, StratumMaterial.SHARD_EPIC, StratumMaterial.SHARD_LEGENDARY);
    }
}
