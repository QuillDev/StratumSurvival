package moe.quill.Crafting.Recipes.Armor.Light.Helmets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightHelmetLeather extends StratumRecipe {
    public CraftLightHelmetLeather(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_LEATHER_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.HELMET_LEATHER_LIGHT));
        recipe.addIngredient(Material.LEATHER_HELMET);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
