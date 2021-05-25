package moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes;

import moe.quill.Crafting.RecipeKey;
import org.bukkit.NamespacedKey;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class ShardRareToEpicRecipe extends ShardRecipe {
    public ShardRareToEpicRecipe( StratumMaterialManager materialManager) {
        super(RecipeKey.SHARD_RARE_TO_EPIC, materialManager, StratumMaterial.SHARD_RARE, StratumMaterial.SHARD_EPIC);
    }
}
