package moe.quill.Crafting.StratumRecipes.Weapons.Daggers;

import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import moe.quill.Crafting.StratumRecipes.Weapons.AbstractRecipes.CobbleRecipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CraftDaggerStone extends StratumRecipe implements CobbleRecipe {
    public CraftDaggerStone(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_DAGGER_STONE, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.DAGGER_STONE));
        recipe.shape("...", ".M.", "S..");
        recipe.setIngredient('M', getMaterialChoice());
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
