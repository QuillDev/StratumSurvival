package moe.quill.Crafting.Recipes.Armor.Light.Boots;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightBootsChain extends StratumRecipe {
    public CraftLightBootsChain(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_CHAIN_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.BOOTS_CHAIN_LIGHT));
        recipe.addIngredient(Material.CHAINMAIL_BOOTS);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
