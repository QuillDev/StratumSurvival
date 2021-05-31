package moe.quill.stratumsurvival.Crafting.Recipes.Materials.FragmentRecipes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Materials.BlockRecipe;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class FragmentToShardCommon extends BlockRecipe {

    public FragmentToShardCommon(MaterialManager materialManager) {
        super(RecipeKey.FRAG_TO_SHARD_COMMON, materialManager, StratumMaterial.FRAGMENT_COMMON, StratumMaterial.SHARD_COMMON);
    }
}
