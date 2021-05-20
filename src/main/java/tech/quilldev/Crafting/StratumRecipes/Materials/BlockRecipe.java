package tech.quilldev.Crafting.StratumRecipes.Materials;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterialManager;

public class BlockRecipe extends StratumRecipe {

    protected final StratumMaterial outMaterial;
    protected final StratumMaterial inMaterial;

    public BlockRecipe(NamespacedKey key, StratumMaterialManager materialManager, StratumMaterial inMaterial, StratumMaterial outMaterial) {
        super(key, materialManager);
        this.outMaterial = outMaterial;
        this.inMaterial = inMaterial;
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(outMaterial));
        recipe.addIngredient(9, materialManager.getItem(inMaterial));
        return recipe;
    }
}
