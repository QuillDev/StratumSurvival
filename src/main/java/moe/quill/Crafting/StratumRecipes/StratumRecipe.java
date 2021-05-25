package moe.quill.Crafting.StratumRecipes;

import moe.quill.Crafting.RecipeKey;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.CustomItems.ItemHelpers.ItemHelper;

public abstract class StratumRecipe {

    protected final String key;
    protected final StratumMaterialManager materialManager;
    protected final ItemHelper itemHelper = new ItemHelper();

    public StratumRecipe(RecipeKey key, StratumMaterialManager materialManager) {
        this.key = key.name();
        this.materialManager = materialManager;
    }

    public StratumRecipe(String key, StratumMaterialManager materialManager) {
        this.key = key;
        this.materialManager = materialManager;
    }

    public abstract Recipe getRecipe(NamespacedKey key);

    public String getRecipeKey() {
        return key;
    }
}
