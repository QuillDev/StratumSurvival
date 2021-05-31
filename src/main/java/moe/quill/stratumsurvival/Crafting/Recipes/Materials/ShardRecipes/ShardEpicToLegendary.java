package moe.quill.stratumsurvival.Crafting.Recipes.Materials.ShardRecipes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class ShardEpicToLegendary extends ShardRecipe {
    public ShardEpicToLegendary(MaterialManager materialManager) {
        super(RecipeKey.SHARD_EPIC_TO_LEGENDARY, materialManager, StratumMaterial.SHARD_EPIC, StratumMaterial.SHARD_LEGENDARY);
    }
}
