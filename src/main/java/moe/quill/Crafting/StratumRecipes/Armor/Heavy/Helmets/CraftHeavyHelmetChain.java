package moe.quill.Crafting.StratumRecipes.Armor.Heavy.Helmets;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftHeavyHelmetChain extends StratumRecipe {
    public CraftHeavyHelmetChain(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPIE_HELMET_CHAIN_HEAVY, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.HELMET_CHAIN_HEAVY));
        recipe.addIngredient(Material.CHAINMAIL_HELMET);
        recipe.addIngredient(Material.OBSIDIAN);
        return recipe;
    }
}