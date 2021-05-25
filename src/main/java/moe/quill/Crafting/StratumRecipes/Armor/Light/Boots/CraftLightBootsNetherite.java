package moe.quill.Crafting.StratumRecipes.Armor.Light.Boots;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightBootsNetherite extends StratumRecipe {
    public CraftLightBootsNetherite(StratumMaterialManager materialManager) {
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
