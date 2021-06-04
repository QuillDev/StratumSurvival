package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Daggers;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import moe.quill.stratumsurvival.Crafting.Recipes.Weapons.AbstractRecipes.WoodRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CraftDaggerWooden extends StratumRecipe implements WoodRecipe {
    public CraftDaggerWooden(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_DAGGER_WOODEN, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.DAGGER_WOODEN));
        recipe.shape("...", ".M.", "S..");
        recipe.setIngredient('M', getMaterialChoice());
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
