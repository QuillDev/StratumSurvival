package moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes;

import moe.quill.Crafting.RecipeKey;
import org.bukkit.NamespacedKey;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class ShardCommonToUncommonRecipe extends ShardRecipe {
    public ShardCommonToUncommonRecipe(StratumMaterialManager materialManager) {
        super(RecipeKey.SHARD_COMMON_TO_UNCOMMON, materialManager, StratumMaterial.SHARD_COMMON, StratumMaterial.SHARD_UNCOMMON);
    }
}
