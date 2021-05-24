package moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;

public class ShardRecipe extends StratumRecipe {

    protected final StratumMaterial input;
    protected final StratumMaterial output;
    protected final int shardCount = 4;

    public ShardRecipe(NamespacedKey key, StratumMaterialManager materialManager, StratumMaterial input, StratumMaterial output) {
        super(key, materialManager);
        this.input = input;
        this.output = output;
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(this.output));
        recipe.addIngredient(shardCount, materialManager.getItem(this.input));
        return recipe;
    }
}
