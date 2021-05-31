package moe.quill.Crafting.Recipes.Armor.Light.Boots;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightBootsNetherite extends StratumRecipe {
    public CraftLightBootsNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_NETHERITE_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.BOOTS_NETHERITE_LIGHT));
        recipe.addIngredient(Material.NETHERITE_BOOTS);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
