package tech.quilldev.Crafting.StratumRecipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;
import tech.quilldev.CustomItemsv2.ItemHelpers.ItemHelper;

public abstract class StratumRecipe {

    protected final NamespacedKey key;
    protected final StratumMaterialManager materialManager;
    protected final ItemHelper itemHelper = new ItemHelper();

    public StratumRecipe(NamespacedKey key, StratumMaterialManager materialManager) {
        this.key = key;
        this.materialManager = materialManager;
    }

    public abstract Recipe getRecipe();

    public NamespacedKey getKey() {
        return key;
    }
}
