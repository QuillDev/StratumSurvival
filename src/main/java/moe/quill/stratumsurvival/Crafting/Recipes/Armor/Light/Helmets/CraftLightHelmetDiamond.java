package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Light.Helmets;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightHelmetDiamond extends StratumRecipe {
    public CraftLightHelmetDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_DIAMOND_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.HELMET_DIAMOND_LIGHT));
        recipe.addIngredient(Material.DIAMOND_HELMET);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
