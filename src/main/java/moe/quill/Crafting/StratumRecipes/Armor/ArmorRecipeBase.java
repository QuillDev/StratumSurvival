package moe.quill.Crafting.StratumRecipes.Armor;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public abstract class ArmorRecipeBase extends StratumRecipe {
    private final RecipeChoice choice;
    private final RecipeChoice addition;
    private final StratumMaterial result;
    private final int additionCount;

    public ArmorRecipeBase(RecipeKey key, StratumMaterialManager materialManager, RecipeChoice choice, RecipeChoice addition, int additionCount, StratumMaterial result) {
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
