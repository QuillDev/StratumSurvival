package moe.quill.Crafting.Recipes.Armor.Light.Chestplates;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightChestplateIron extends StratumRecipe {
    public CraftLightChestplateIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_IRON_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.CHESTPLATE_IRON_LIGHT));
        recipe.addIngredient(Material.IRON_CHESTPLATE);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
