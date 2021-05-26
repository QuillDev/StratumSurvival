package moe.quill.Crafting.Recipes.Armor.Light.Leggings;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightLeggingsIron extends StratumRecipe {
    public CraftLightLeggingsIron(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_IRON_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.LEGGINGS_IRON_LIGHT));
        recipe.addIngredient(Material.IRON_LEGGINGS);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
