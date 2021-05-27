package moe.quill.Crafting.Recipes.Weapons.Cutlasses;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Weapons.AbstractRecipes.WoodRecipe;

public class CraftCutlassWooden extends CutlassRecipeBase implements WoodRecipe {
    public CraftCutlassWooden(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_WOODEN, materialManager, choice, StratumMaterial.CUTLASS_WOODEN);
    }
}