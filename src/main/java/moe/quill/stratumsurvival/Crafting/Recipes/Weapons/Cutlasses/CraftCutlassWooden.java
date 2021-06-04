package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Cutlasses;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.Weapons.AbstractRecipes.WoodRecipe;

public class CraftCutlassWooden extends CutlassRecipeBase implements WoodRecipe {
    public CraftCutlassWooden(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_WOODEN, materialManager, choice, StratumMaterial.CUTLASS_WOODEN);
    }
}
