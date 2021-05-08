package tech.quilldev.Crafting.StratumRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;

public class TestRecipe extends StratumRecipe {
    public TestRecipe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key, new ItemStack(Material.EMERALD));
        recipe.shape("III", ".SD", ".S.");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('D', materialManager.getItem(StratumMaterial.SHARD_COMMON));
        return recipe;
    }
}
