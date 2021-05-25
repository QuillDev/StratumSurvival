package moe.quill.Crafting.StratumRecipes.Armor.Heavy.Boots;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftHeavyBootsDiamond extends StratumRecipe {
    public CraftHeavyBootsDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_DIAMOND_HEAVY, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.BOOTS_DIAMOND_HEAVY));
        recipe.addIngredient(Material.DIAMOND_BOOTS);
        recipe.addIngredient(Material.OBSIDIAN);
        return recipe;
    }
}
