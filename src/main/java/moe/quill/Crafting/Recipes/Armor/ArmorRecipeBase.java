package moe.quill.Crafting.Recipes.Armor;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public abstract class ArmorRecipeBase extends StratumRecipe {
    private final RecipeChoice choice;
    private final RecipeChoice addition;
    private final StratumMaterial result;
    private final int additionCount;

    public ArmorRecipeBase(RecipeKey key, MaterialManager materialManager, RecipeChoice choice, RecipeChoice addition, int additionCount, StratumMaterial result) {
        super(key, materialManager);
        this.choice = choice;
        this.result = result;
        this.addition = addition;
        this.additionCount = additionCount;
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(result));
        recipe.addIngredient(choice);

        for (int i = 0; i < additionCount; i++) {
            recipe.addIngredient(addition);
        }
        return recipe;
    }
}
