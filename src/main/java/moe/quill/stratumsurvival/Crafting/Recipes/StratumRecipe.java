package moe.quill.stratumsurvival.Crafting.Recipes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;

public abstract class StratumRecipe {

    protected final String key;
    protected final MaterialManager materialManager;

    public StratumRecipe(RecipeKey key, MaterialManager materialManager) {
        this.key = key.name();
        this.materialManager = materialManager;
    }

    public StratumRecipe(String key, MaterialManager materialManager) {
        this.key = key;
        this.materialManager = materialManager;
    }

    public abstract Recipe getRecipe(NamespacedKey key);

    public String getRecipeKey() {
        return key;
    }
}
