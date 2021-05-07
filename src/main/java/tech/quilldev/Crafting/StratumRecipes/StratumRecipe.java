package tech.quilldev.Crafting.StratumRecipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;

public abstract class StratumRecipe {

    protected final NamespacedKey key;

    public StratumRecipe(NamespacedKey key) {
        this.key = key;
    }

    public abstract Recipe getRecipe();

    public NamespacedKey getKey() {
        return key;
    }
}
