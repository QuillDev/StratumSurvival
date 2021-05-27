package moe.quill.Crafting.Recipes.Armor.Heavy.Boots;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftHeavyBootsIron extends StratumRecipe {
    public CraftHeavyBootsIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_IRON_HEAVY, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.BOOTS_IRON_HEAVY));
        recipe.addIngredient(Material.IRON_BOOTS);
        recipe.addIngredient(Material.OBSIDIAN);
        return recipe;
    }
}
