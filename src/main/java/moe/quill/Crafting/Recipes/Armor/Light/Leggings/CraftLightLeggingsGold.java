package moe.quill.Crafting.Recipes.Armor.Light.Leggings;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightLeggingsGold extends StratumRecipe {
    public CraftLightLeggingsGold(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_GOLDEN_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.LEGGINGS_GOLDEN_LIGHT));
        recipe.addIngredient(Material.GOLDEN_LEGGINGS);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
