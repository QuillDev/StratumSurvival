package moe.quill.Crafting.StratumRecipes.Armor.Heavy.Leggings;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftHeavyLeggingsDiamond extends StratumRecipe {
    public CraftHeavyLeggingsDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPIE_LEGGINGS_DIAMOND_HEAVY, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.LEGGINGS_DIAMOND_HEAVY));
        recipe.addIngredient(Material.DIAMOND_LEGGINGS);
        recipe.addIngredient(Material.OBSIDIAN);
        return recipe;
    }
}