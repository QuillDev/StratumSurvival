package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Light.Leggings;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightLeggingsDiamond extends StratumRecipe {
    public CraftLightLeggingsDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_DIAMOND_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.LEGGINGS_DIAMOND_LIGHT));
        recipe.addIngredient(Material.DIAMOND_LEGGINGS);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
