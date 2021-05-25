package moe.quill.Crafting.StratumRecipes.Armor.Light.Chestplates;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightChestplateGold extends StratumRecipe {
    public CraftLightChestplateGold(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_GOLDEN_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.CHESTPLATE_GOLDEN_LIGHT));
        recipe.addIngredient(Material.GOLDEN_CHESTPLATE);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
