package moe.quill.stratumsurvival.Crafting.Recipes.Materials.FragmentRecipes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Materials.BlockRecipe;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class FragmentToShardEpic extends BlockRecipe {
    public FragmentToShardEpic(MaterialManager materialManager) {
        super(RecipeKey.FRAG_TO_SHARD_EPIC, materialManager, StratumMaterial.FRAGMENT_EPIC, StratumMaterial.SHARD_EPIC);
    }
}
