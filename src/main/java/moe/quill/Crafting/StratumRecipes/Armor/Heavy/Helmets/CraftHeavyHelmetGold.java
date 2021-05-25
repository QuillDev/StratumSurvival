package moe.quill.Crafting.StratumRecipes.Armor.Heavy.Helmets;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftHeavyHelmetGold extends StratumRecipe {
    public CraftHeavyHelmetGold(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_GOLDEN_HEAVY, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.HELMET_GOLDEN_HEAVY));
        recipe.addIngredient(Material.GOLDEN_HELMET);
        recipe.addIngredient(Material.OBSIDIAN);
        return recipe;
    }
}
