package moe.quill.Crafting.Recipes.Materials.ShardRecipes;

import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;

public class ShardRareToEpicRecipe extends ShardRecipe {
    public ShardRareToEpicRecipe( StratumMaterialManager materialManager) {
        super(RecipeKey.SHARD_RARE_TO_EPIC, materialManager, StratumMaterial.SHARD_RARE, StratumMaterial.SHARD_EPIC);
    }
}
