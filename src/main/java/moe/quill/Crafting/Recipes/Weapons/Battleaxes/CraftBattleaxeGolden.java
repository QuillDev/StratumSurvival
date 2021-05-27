package moe.quill.Crafting.Recipes.Weapons.Battleaxes;

import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CraftBattleaxeGolden extends StratumRecipe {
    public CraftBattleaxeGolden(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BATTLEAXE_GOLDEN, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.BATTLEAXE_GOLDEN));
        recipe.shape("MMM", "MSM", ".S.");
        recipe.setIngredient('M', Material.GOLD_INGOT);
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }
}
