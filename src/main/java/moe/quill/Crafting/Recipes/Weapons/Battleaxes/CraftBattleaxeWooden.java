package moe.quill.Crafting.Recipes.Weapons.Battleaxes;

import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import moe.quill.Crafting.Recipes.Weapons.AbstractRecipes.WoodRecipe;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.StratumRecipe;

public class CraftBattleaxeWooden extends StratumRecipe implements WoodRecipe {
    public CraftBattleaxeWooden(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BATTLEAXE_WOODEN, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.BATTLEAXE_WOODEN));
        recipe.shape("MMM", "MSM", ".S.");
        recipe.setIngredient('M', getMaterialChoice());
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }
}