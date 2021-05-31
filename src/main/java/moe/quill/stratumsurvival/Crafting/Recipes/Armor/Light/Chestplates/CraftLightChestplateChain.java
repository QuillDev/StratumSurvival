package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Light.Chestplates;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftLightChestplateChain extends StratumRecipe {
    public CraftLightChestplateChain(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_CHAIN_LIGHT, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.CHESTPLATE_CHAIN_LIGHT));
        recipe.addIngredient(Material.CHAINMAIL_CHESTPLATE);
        recipe.addIngredient(Material.LEATHER);
        return recipe;
    }
}
