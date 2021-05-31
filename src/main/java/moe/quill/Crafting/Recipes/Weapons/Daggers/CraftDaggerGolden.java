package moe.quill.Crafting.Recipes.Weapons.Daggers;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CraftDaggerGolden extends StratumRecipe {
    public CraftDaggerGolden(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_DAGGER_GOLDEN, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.DAGGER_GOLDEN));
        recipe.shape("...", ".M.", "S..");
        recipe.setIngredient('M', Material.GOLD_INGOT);
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
