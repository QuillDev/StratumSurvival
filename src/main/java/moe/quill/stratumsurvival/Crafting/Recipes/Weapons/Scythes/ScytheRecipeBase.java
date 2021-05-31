package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Scythes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public abstract class ScytheRecipeBase extends StratumRecipe {

    private final RecipeChoice choice;
    private final StratumMaterial result;

    public ScytheRecipeBase(RecipeKey key, MaterialManager materialManager, RecipeChoice choice, StratumMaterial result) {
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
