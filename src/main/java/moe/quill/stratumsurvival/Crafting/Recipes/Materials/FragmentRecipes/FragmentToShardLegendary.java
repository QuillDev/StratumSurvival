package moe.quill.stratumsurvival.Crafting.Recipes.Materials.FragmentRecipes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Materials.BlockRecipe;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class FragmentToShardLegendary extends BlockRecipe {

    public FragmentToShardLegendary(MaterialManager materialManager) {
        super(RecipeKey.FRAG_TO_SHARD_LEGENDARY, materialManager, StratumMaterial.FRAGMENT_LEGENDARY, StratumMaterial.SHARD_LEGENDARY);
    }
}
