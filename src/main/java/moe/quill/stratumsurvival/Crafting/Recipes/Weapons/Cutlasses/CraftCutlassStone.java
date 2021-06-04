package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Cutlasses;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.Weapons.AbstractRecipes.StoneRecipe;

public class CraftCutlassStone extends CutlassRecipeBase implements StoneRecipe {
    public CraftCutlassStone(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_STONE, materialManager, choice, StratumMaterial.CUTLASS_STONE);
    }
}
