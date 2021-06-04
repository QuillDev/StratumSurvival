package moe.quill.stratumsurvival.Crafting.Recipes.Materials.FragmentRecipes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Materials.BlockRecipe;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class FragmentToShardRare extends BlockRecipe {
    public FragmentToShardRare(MaterialManager materialManager) {
        super(RecipeKey.FRAG_TO_SHARD_RARE, materialManager, StratumMaterial.FRAGMENT_RARE, StratumMaterial.SHARD_RARE);
    }
}
