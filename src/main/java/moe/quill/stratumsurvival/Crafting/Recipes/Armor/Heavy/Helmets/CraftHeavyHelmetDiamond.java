package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Heavy.Helmets;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftHeavyHelmetDiamond extends StratumRecipe {
    public CraftHeavyHelmetDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_DIAMOND_HEAVY, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.HELMET_DIAMOND_HEAVY));
        recipe.addIngredient(Material.DIAMOND_HELMET);
        recipe.addIngredient(Material.OBSIDIAN);
        return recipe;
    }
}
