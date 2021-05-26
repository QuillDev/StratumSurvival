package moe.quill.Crafting.Recipes.Materials.ShardRecipes;

import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;

public class ShardCommonToUncommonRecipe extends ShardRecipe {
    public ShardCommonToUncommonRecipe(StratumMaterialManager materialManager) {
        super(RecipeKey.SHARD_COMMON_TO_UNCOMMON, materialManager, StratumMaterial.SHARD_COMMON, StratumMaterial.SHARD_UNCOMMON);
    }
}
