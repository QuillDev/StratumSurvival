package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Heavy.Leggings;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftHeavyLeggingsNetherite extends StratumRecipe {
    public CraftHeavyLeggingsNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_NETHERITE_HEAVY, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.LEGGINGS_NETHERITE_HEAVY));
        recipe.addIngredient(Material.NETHERITE_LEGGINGS);
        recipe.addIngredient(Material.OBSIDIAN);
        return recipe;
    }
}
