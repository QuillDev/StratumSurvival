package moe.quill.Crafting.StratumRecipes.Materials.FragmentRecipes;

import moe.quill.Crafting.RecipeKey;
import org.bukkit.NamespacedKey;
import moe.quill.Crafting.StratumRecipes.Materials.BlockRecipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class FragmentToShardLegendary extends BlockRecipe {

    public FragmentToShardLegendary(StratumMaterialManager materialManager) {
        super(RecipeKey.FRAG_TO_SHARD_LEGENDARY, materialManager, StratumMaterial.FRAGMENT_LEGENDARY, StratumMaterial.SHARD_LEGENDARY);
    }
}
