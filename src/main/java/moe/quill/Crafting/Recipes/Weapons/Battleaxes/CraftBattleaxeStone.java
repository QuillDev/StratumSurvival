package moe.quill.Crafting.Recipes.Weapons.Battleaxes;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import moe.quill.Crafting.Recipes.Weapons.AbstractRecipes.StoneRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CraftBattleaxeStone extends StratumRecipe implements StoneRecipe {
    public CraftBattleaxeStone(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BATTLEAXE_STONE, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.BATTLEAXE_STONE));
        recipe.shape("MMM", "MSM", ".S.");
        recipe.setIngredient('M', getMaterialChoice());
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }
}
