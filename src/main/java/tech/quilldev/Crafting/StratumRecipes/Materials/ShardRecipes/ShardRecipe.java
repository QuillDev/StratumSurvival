package tech.quilldev.Crafting.StratumRecipes.Materials.ShardRecipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterialManager;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;

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
