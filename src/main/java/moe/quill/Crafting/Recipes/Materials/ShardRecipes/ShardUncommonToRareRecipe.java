package moe.quill.Crafting.Recipes.Materials.ShardRecipes;

import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;

public class ShardUncommonToRareRecipe extends ShardRecipe {
    public ShardUncommonToRareRecipe(MaterialManager materialManager) {
        super(RecipeKey.SHARD_UNCOMMON_TO_RARE, materialManager, StratumMaterial.SHARD_UNCOMMON, StratumMaterial.SHARD_RARE);
    }
}
