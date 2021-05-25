package moe.quill.Crafting.StratumRecipes.Materials.FragmentRecipes;

import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Materials.BlockRecipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class FragmentToShardCommon extends BlockRecipe {

    public FragmentToShardCommon(StratumMaterialManager materialManager) {
        super(RecipeKey.FRAG_TO_SHARD_COMMON, materialManager, StratumMaterial.FRAGMENT_COMMON, StratumMaterial.SHARD_COMMON);
    }
}
