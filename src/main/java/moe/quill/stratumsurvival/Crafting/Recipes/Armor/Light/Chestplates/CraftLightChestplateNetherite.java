package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Light.Chestplates;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightChestplateNetherite extends StratumRecipe {
    public CraftLightChestplateNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_NETHERITE_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.CHESTPLATE_NETHERITE_LIGHT));
        recipe.addIngredient(Material.NETHERITE_CHESTPLATE);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
