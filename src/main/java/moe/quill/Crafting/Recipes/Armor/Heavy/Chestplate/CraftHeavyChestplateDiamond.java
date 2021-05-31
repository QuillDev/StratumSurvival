package moe.quill.Crafting.Recipes.Armor.Heavy.Chestplate;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftHeavyChestplateDiamond extends StratumRecipe {
    public CraftHeavyChestplateDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_DIAMOND_HEAVY, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.CHESTPLATE_DIAMOND_HEAVY));
        recipe.addIngredient(Material.DIAMOND_CHESTPLATE);
        recipe.addIngredient(Material.OBSIDIAN);
        return recipe;
    }
}
