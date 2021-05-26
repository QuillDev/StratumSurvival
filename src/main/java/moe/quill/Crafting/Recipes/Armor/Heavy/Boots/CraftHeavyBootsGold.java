package moe.quill.Crafting.Recipes.Armor.Heavy.Boots;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftHeavyBootsGold extends StratumRecipe {
    public CraftHeavyBootsGold(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_GOLDEN_HEAVY, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.BOOTS_GOLDEN_HEAVY));
        recipe.addIngredient(Material.GOLDEN_BOOTS);
        recipe.addIngredient(Material.OBSIDIAN);
        return recipe;
    }
}
