package moe.quill.Crafting.StratumRecipes.Weapons.Daggers;

import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import moe.quill.Crafting.StratumRecipes.Weapons.AbstractRecipes.WoodRecipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CraftDaggerWooden extends StratumRecipe implements WoodRecipe {
    public CraftDaggerWooden(StratumMaterialManager materialManager) {
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
