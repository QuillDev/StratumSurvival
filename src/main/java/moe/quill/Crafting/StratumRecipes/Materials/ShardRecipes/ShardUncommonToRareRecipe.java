package moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes;

import org.bukkit.NamespacedKey;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class ShardUncommonToRareRecipe extends ShardRecipe {
    public ShardUncommonToRareRecipe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SHARD_UNCOMMON, StratumMaterial.SHARD_RARE);
    }
}
