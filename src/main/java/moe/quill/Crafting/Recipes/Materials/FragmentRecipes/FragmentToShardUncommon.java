package moe.quill.Crafting.Recipes.Materials.FragmentRecipes;

import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Materials.BlockRecipe;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;

public class FragmentToShardUncommon extends BlockRecipe {
    public FragmentToShardUncommon(StratumMaterialManager materialManager) {
        super(RecipeKey.FRAG_TO_SHARD_UNCOMMON, materialManager, StratumMaterial.FRAGMENT_UNCOMMON, StratumMaterial.SHARD_UNCOMMON);
    }
}
