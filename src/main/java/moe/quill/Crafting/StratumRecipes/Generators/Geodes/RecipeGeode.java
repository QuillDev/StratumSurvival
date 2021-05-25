package moe.quill.Crafting.StratumRecipes.Generators.Geodes;

import moe.quill.Utils.Annotations.IgnoreDynamicLoading;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;

@IgnoreDynamicLoading
public class RecipeGeode extends StratumRecipe {

    protected StratumMaterial output;
    protected StratumMaterial mineral;
    protected RecipeChoice input;

    public RecipeGeode(String key, StratumMaterialManager materialManager, StratumMaterial output, StratumMaterial mineral, RecipeChoice input) {
        super(key, materialManager);
        this.output = output;
        this.mineral = mineral;
        this.input = input;
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(output));
        recipe.addIngredient(1, materialManager.getItem(mineral));
        recipe.addIngredient(input);
        return recipe;
    }
}
