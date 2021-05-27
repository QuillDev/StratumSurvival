package moe.quill.Crafting.Recipes.Materials.FragmentRecipes;

import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Materials.BlockRecipe;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;

public class FragmentToShardLegendary extends BlockRecipe {

    public FragmentToShardLegendary(MaterialManager materialManager) {
        super(RecipeKey.FRAG_TO_SHARD_LEGENDARY, materialManager, StratumMaterial.FRAGMENT_LEGENDARY, StratumMaterial.SHARD_LEGENDARY);
    }
}
