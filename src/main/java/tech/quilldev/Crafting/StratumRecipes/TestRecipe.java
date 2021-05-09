package tech.quilldev.Crafting.StratumRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;

public class TestRecipe extends StratumRecipe {
    public TestRecipe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.GEODE_COMMON));
        recipe.addIngredient(1, materialManager.getItem(StratumMaterial.BATTLEAXE_WOODEN));
        recipe.addIngredient(1, materialManager.getItem(StratumMaterial.SHARD_COMMON));
        return recipe;
    }
}
