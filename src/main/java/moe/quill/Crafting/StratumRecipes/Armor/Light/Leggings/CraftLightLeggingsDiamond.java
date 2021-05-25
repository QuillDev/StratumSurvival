package moe.quill.Crafting.StratumRecipes.Armor.Light.Leggings;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightLeggingsDiamond extends StratumRecipe {
    public CraftLightLeggingsDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPIE_LEGGINGS_DIAMOND_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.LEGGINGS_DIAMOND_LIGHT));
        recipe.addIngredient(Material.DIAMOND_LEGGINGS);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
