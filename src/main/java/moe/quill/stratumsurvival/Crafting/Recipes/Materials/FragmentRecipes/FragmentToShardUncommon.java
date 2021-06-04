package moe.quill.stratumsurvival.Crafting.Recipes.Materials.FragmentRecipes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Materials.BlockRecipe;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class FragmentToShardUncommon extends BlockRecipe {
    public FragmentToShardUncommon(MaterialManager materialManager) {
        super(RecipeKey.FRAG_TO_SHARD_UNCOMMON, materialManager, StratumMaterial.FRAGMENT_UNCOMMON, StratumMaterial.SHARD_UNCOMMON);
    }
}
