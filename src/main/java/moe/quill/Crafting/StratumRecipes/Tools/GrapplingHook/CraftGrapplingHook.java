package moe.quill.Crafting.StratumRecipes.Tools.GrapplingHook;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

@SuppressWarnings("unused")
public class CraftGrapplingHook extends StratumRecipe {
    public CraftGrapplingHook(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_GRAPPLING_HOOK, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.GRAPPLING_HOOK));
        recipe.shape(
                "__S",
                "_IT",
                "/__"
        );
        recipe.setIngredient('S', Material.STRING);
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('/', Material.STICK);
        recipe.setIngredient('T', Material.TRIPWIRE_HOOK);
        return recipe;
    }
}
