package tech.quilldev.Crafting.StratumRecipes.CrystalRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;

public class ShardEpicToLegendary extends ShardRecipe {
    public ShardEpicToLegendary(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SHARD_EPIC, StratumMaterial.SHARD_LEGENDARY);
    }
}
