package tech.quilldev.Crafting.StratumRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumMaterial;

public class TestRecipe extends StratumRecipe {
    public TestRecipe(NamespacedKey key) {
        super(key);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key, new ItemStack(Material.EMERALD));
        recipe.shape("III", ".SD", ".S.");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('D', StratumMaterial.SHARD_COMMON);
        return recipe;
    }
}
