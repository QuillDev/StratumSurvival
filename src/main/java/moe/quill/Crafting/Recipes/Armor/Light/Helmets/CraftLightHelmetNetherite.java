package moe.quill.Crafting.Recipes.Armor.Light.Helmets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightHelmetNetherite extends StratumRecipe {
    public CraftLightHelmetNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_NETHERITE_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.HELMET_NETHERITE_LIGHT));
        recipe.addIngredient(Material.NETHERITE_HELMET);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
