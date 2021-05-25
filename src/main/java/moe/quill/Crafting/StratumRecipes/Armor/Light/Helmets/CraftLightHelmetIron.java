package moe.quill.Crafting.StratumRecipes.Armor.Light.Helmets;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightHelmetIron extends StratumRecipe {
    public CraftLightHelmetIron(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPIE_HELMET_IRON_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.HELMET_IRON_LIGHT));
        recipe.addIngredient(Material.IRON_HELMET);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
