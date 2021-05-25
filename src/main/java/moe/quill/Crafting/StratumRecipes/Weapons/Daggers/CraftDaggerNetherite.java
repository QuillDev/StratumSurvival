package moe.quill.Crafting.StratumRecipes.Weapons.Daggers;

import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftDaggerNetherite extends StratumRecipe {
    public CraftDaggerNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_DAGGER_NETHERITE, materialManager);
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.DAGGER_NETHERITE));
        recipe.addIngredient(1, materialManager.getItem(StratumMaterial.DAGGER_DIAMOND));
        recipe.addIngredient(1, Material.NETHERITE_INGOT);

        return recipe;
    }
}
