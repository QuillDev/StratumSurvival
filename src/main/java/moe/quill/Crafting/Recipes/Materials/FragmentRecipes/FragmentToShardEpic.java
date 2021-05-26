package moe.quill.Crafting.Recipes.Materials.FragmentRecipes;

import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Materials.BlockRecipe;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;

public class FragmentToShardEpic extends BlockRecipe {
    public FragmentToShardEpic(StratumMaterialManager materialManager) {
        super(RecipeKey.FRAG_TO_SHARD_EPIC, materialManager, StratumMaterial.FRAGMENT_EPIC, StratumMaterial.SHARD_EPIC);
    }
}
