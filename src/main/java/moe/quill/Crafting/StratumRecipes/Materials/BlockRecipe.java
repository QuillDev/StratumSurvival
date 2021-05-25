package moe.quill.Crafting.StratumRecipes.Materials;

import moe.quill.Crafting.RecipeKey;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public abstract class BlockRecipe extends StratumRecipe {

    protected final StratumMaterial outMaterial;
    protected final StratumMaterial inMaterial;

    public BlockRecipe(RecipeKey recipeKey, StratumMaterialManager materialManager, StratumMaterial inMaterial, StratumMaterial outMaterial) {
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
