package moe.quill.Crafting.StratumRecipes.Weapons.Cutlasses;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public abstract class CutlassRecipeBase extends StratumRecipe {

    private final RecipeChoice material;
    private final StratumMaterial result;

    public CutlassRecipeBase(RecipeKey key, StratumMaterialManager materialManager, RecipeChoice material, StratumMaterial result) {
        super(key, materialManager);
        this.material = material;
        this.result = result;
    }

    @Override
    public Recipe getRecipe(NamespacedKey key) {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(result));
        recipe.shape(
                "__M",
                "GM_",
                "S__"
        );
        recipe.setIngredient('M', material);
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('G', Material.GOLD_INGOT);
        return recipe;
    }
}
