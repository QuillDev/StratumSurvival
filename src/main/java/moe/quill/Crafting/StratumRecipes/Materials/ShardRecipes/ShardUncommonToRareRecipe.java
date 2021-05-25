package moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes;

import moe.quill.Crafting.RecipeKey;
import org.bukkit.NamespacedKey;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class ShardUncommonToRareRecipe extends ShardRecipe {
    public ShardUncommonToRareRecipe(StratumMaterialManager materialManager) {
        super(RecipeKey.SHARD_UNCOMMON_TO_RARE, materialManager, StratumMaterial.SHARD_UNCOMMON, StratumMaterial.SHARD_RARE);
    }
}
