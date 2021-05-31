package moe.quill.stratumsurvival.Crafting.Recipes.Trinkets;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CraftTrinketBagSmall extends StratumRecipe {
    public CraftTrinketBagSmall(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_TRINKET_BAG_SMALL, materialManager);
    }

    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.TRINKET_BAG_SMALL));
        recipe.shape(
                "LLL",
                "L_L",
                "LLL"
        );
        recipe.setIngredient('L', Material.LEATHER);
        return recipe;
    }
}
