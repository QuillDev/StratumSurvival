package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.AbstractRecipes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public abstract class StratumSmithRecipe extends StratumRecipe {

    private StratumMaterial input;
    private StratumMaterial result;

    public StratumSmithRecipe(RecipeKey key, MaterialManager materialManager, StratumMaterial input, StratumMaterial result) {
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
