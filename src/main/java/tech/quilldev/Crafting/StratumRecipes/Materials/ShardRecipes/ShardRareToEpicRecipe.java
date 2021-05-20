package tech.quilldev.Crafting.StratumRecipes.Materials.ShardRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterialManager;

public class ShardRareToEpicRecipe extends ShardRecipe {
    public ShardRareToEpicRecipe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SHARD_RARE, StratumMaterial.SHARD_EPIC);
    }
}
