package moe.quill.Crafting.StratumRecipes.Weapons.Cutlasses;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Weapons.AbstractRecipes.WoodRecipe;

public class CraftCutlassWooden extends CutlassRecipeBase implements WoodRecipe {
    public CraftCutlassWooden(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_WOODEN, materialManager, choice, StratumMaterial.CUTLASS_WOODEN);
    }
}
