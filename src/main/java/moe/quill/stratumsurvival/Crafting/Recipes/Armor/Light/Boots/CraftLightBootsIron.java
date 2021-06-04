package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Light.Boots;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightBootsIron extends StratumRecipe {
    public CraftLightBootsIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_IRON_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.BOOTS_IRON_LIGHT));
        recipe.addIngredient(Material.IRON_BOOTS);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
