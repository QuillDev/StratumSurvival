package moe.quill.Crafting.Recipes.Weapons.AbstractRecipes;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public abstract class StratumSmithRecipe extends StratumRecipe {

    private StratumMaterial input;
    private StratumMaterial result;

    public StratumSmithRecipe(RecipeKey key, StratumMaterialManager materialManager, StratumMaterial input, StratumMaterial result) {
        super(key, materialManager);
        this.input = input;
        this.result = result;
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(result));
        recipe.addIngredient(materialManager.getItem(input));
        recipe.addIngredient(Material.NETHERITE_INGOT);
        return recipe;
    }
}
