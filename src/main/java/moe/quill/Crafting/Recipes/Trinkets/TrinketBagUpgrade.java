package moe.quill.Crafting.Recipes.Trinkets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.StratumRecipe;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public abstract class TrinketBagUpgrade extends StratumRecipe {

    private final RecipeChoice base;
    private final RecipeChoice shard;
    private final StratumMaterial result;

    public TrinketBagUpgrade(RecipeKey key, MaterialManager materialManager, StratumMaterial result, RecipeChoice base, RecipeChoice shard) {
        super(key, materialManager);
        this.result = result;
        this.base = base;
        this.shard = shard;
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(result));
        recipe.addIngredient(base);
        recipe.addIngredient(shard);
        return recipe;
    }
}
