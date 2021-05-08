package tech.quilldev.Crafting.StratumRecipes.CrystalRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;

public class ShardRareToEpicRecipe extends ShardRecipe {
    public ShardRareToEpicRecipe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SHARD_RARE, StratumMaterial.SHARD_EPIC);
    }
}
