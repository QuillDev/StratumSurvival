package moe.quill.Crafting.StratumRecipes.Weapons.Battleaxes;

import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CraftBattleaxeDiamond extends StratumRecipe {
    public CraftBattleaxeDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BATTLEAXE_DIAMOND, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.BATTLEAXE_DIAMOND));
        recipe.shape("MMM", "MSM", ".S.");
        recipe.setIngredient('M', Material.DIAMOND);
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }
}
