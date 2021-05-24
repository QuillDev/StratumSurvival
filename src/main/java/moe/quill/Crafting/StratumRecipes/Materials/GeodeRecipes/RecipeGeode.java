package moe.quill.Crafting.StratumRecipes.Materials.GeodeRecipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;

public class RecipeGeode extends StratumRecipe {

    protected StratumMaterial output;
    protected StratumMaterial mineral;
    protected RecipeChoice input;

    public RecipeGeode(NamespacedKey key, StratumMaterialManager materialManager, StratumMaterial output, StratumMaterial mineral, RecipeChoice input) {
        super(key, materialManager);
        this.output = output;
        this.mineral = mineral;
        this.input = input;
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(output));
        recipe.addIngredient(1, materialManager.getItem(mineral));
        recipe.addIngredient(input);
        return recipe;
    }
}
