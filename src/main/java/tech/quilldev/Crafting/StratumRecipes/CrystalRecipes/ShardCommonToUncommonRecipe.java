package tech.quilldev.Crafting.StratumRecipes.CrystalRecipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;

public class ShardCommonToUncommonRecipe extends ShardRecipe {
    public ShardCommonToUncommonRecipe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SHARD_COMMON, StratumMaterial.SHARD_UNCOMMON);
    }
}
