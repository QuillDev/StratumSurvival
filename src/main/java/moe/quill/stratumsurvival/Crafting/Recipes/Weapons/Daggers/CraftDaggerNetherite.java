package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Daggers;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftDaggerNetherite extends StratumRecipe {
    public CraftDaggerNetherite(MaterialManager materialManager) {
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
