package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Light.Helmets;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightHelmetGold extends StratumRecipe {
    public CraftLightHelmetGold(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_GOLDEN_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.HELMET_GOLDEN_LIGHT));
        recipe.addIngredient(Material.GOLDEN_HELMET);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
