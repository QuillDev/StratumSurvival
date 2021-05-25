package moe.quill.Crafting.StratumRecipes.Armor.Light.Boots;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightBootsLeather extends StratumRecipe {
    public CraftLightBootsLeather(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPIE_BOOTS_LEATHER_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.BOOTS_LEATHER_LIGHT));
        recipe.addIngredient(Material.LEATHER_BOOTS);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
