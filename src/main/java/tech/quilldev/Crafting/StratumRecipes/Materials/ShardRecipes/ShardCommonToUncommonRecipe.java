package tech.quilldev.Crafting.StratumRecipes.Materials.ShardRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;

public class ShardCommonToUncommonRecipe extends ShardRecipe {
    public ShardCommonToUncommonRecipe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SHARD_COMMON, StratumMaterial.SHARD_UNCOMMON);
    }
}
