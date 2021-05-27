package moe.quill.Crafting.Recipes.Materials.ShardRecipes;

import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.StratumRecipe;

public abstract class ShardRecipe extends StratumRecipe {

    protected final StratumMaterial input;
    protected final StratumMaterial output;
    protected final int shardCount = 4;

    public ShardRecipe(RecipeKey key, MaterialManager materialManager, StratumMaterial input, StratumMaterial output) {
        super(key, materialManager);
        this.input = input;
        this.output = output;
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(this.output));
        recipe.addIngredient(shardCount, materialManager.getItem(this.input));
        return recipe;
    }


}
