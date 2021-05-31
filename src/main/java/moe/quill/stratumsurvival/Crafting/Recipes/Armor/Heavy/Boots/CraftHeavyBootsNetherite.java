package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Heavy.Boots;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftHeavyBootsNetherite extends StratumRecipe {
    public CraftHeavyBootsNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_NETHERITE_HEAVY, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.BOOTS_NETHERITE_HEAVY));
        recipe.addIngredient(Material.NETHERITE_BOOTS);
        recipe.addIngredient(Material.OBSIDIAN);
        return recipe;
    }
}
