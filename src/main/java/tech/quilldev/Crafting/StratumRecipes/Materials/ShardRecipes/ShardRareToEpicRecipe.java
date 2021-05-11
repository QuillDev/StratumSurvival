package tech.quilldev.Crafting.StratumRecipes.Materials.ShardRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;

public class ShardRareToEpicRecipe extends ShardRecipe {
    public ShardRareToEpicRecipe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SHARD_RARE, StratumMaterial.SHARD_EPIC);
    }
}
