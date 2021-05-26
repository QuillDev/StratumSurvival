package moe.quill.Crafting.Recipes.Materials.FragmentRecipes;

import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Materials.BlockRecipe;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;

public class FragmentToShardRare extends BlockRecipe {
    public FragmentToShardRare(StratumMaterialManager materialManager) {
        super(RecipeKey.FRAG_TO_SHARD_RARE, materialManager, StratumMaterial.FRAGMENT_RARE, StratumMaterial.SHARD_RARE);
    }
}
