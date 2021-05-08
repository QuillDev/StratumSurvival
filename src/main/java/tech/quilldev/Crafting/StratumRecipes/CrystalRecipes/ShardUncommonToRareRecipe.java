package tech.quilldev.Crafting.StratumRecipes.CrystalRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;

public class ShardUncommonToRareRecipe extends ShardRecipe {
    public ShardUncommonToRareRecipe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SHARD_UNCOMMON, StratumMaterial.SHARD_RARE);
    }
}
