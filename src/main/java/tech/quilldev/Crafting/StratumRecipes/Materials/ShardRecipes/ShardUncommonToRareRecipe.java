package tech.quilldev.Crafting.StratumRecipes.Materials.ShardRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;

public class ShardUncommonToRareRecipe extends ShardRecipe {
    public ShardUncommonToRareRecipe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SHARD_UNCOMMON, StratumMaterial.SHARD_RARE);
    }
}
