package moe.quill.Crafting.StratumRecipes.Weapons.Scythes;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public abstract class ScytheRecipeBase extends StratumRecipe {

    private final RecipeChoice choice;
    private final StratumMaterial result;

    public ScytheRecipeBase(RecipeKey key, StratumMaterialManager materialManager, RecipeChoice choice, StratumMaterial result) {
        super(key, materialManager);
        this.choice = choice;
        this.result = result;
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(result));
        recipe.shape(
                "MMS",
                "_SM",
                "S__"
        );
        recipe.setIngredient('M', choice);
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }
}
