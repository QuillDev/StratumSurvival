package moe.quill.Crafting.Recipes.Materials;

import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import moe.quill.Crafting.Recipes.StratumRecipe;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;

public abstract class BlockRecipe extends StratumRecipe {

    protected final StratumMaterial outMaterial;
    protected final StratumMaterial inMaterial;

    public BlockRecipe(RecipeKey recipeKey, MaterialManager materialManager, StratumMaterial inMaterial, StratumMaterial outMaterial) {
        super(recipeKey, materialManager);
        this.outMaterial = outMaterial;
        this.inMaterial = inMaterial;
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(outMaterial));
        recipe.addIngredient(9, materialManager.getItem(inMaterial));
        return recipe;
    }
}
