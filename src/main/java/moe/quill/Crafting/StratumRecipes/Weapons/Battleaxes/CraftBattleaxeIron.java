package moe.quill.Crafting.StratumRecipes.Weapons.Battleaxes;

import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CraftBattleaxeIron extends StratumRecipe {
    public CraftBattleaxeIron(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BATTLEAXE_IRON, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.BATTLEAXE_IRON));
        recipe.shape("MMM", "MSM", ".S.");
        recipe.setIngredient('M', Material.IRON_INGOT);
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }
}
