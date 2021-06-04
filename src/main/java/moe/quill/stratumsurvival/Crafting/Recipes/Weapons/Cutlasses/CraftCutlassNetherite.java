package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Cutlasses;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.Weapons.AbstractRecipes.StratumSmithRecipe;

public class CraftCutlassNetherite extends StratumSmithRecipe {
    public CraftCutlassNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_NETHERITE, materialManager, StratumMaterial.CUTLASS_DIAMOND, StratumMaterial.CUTLASS_NETHERITE);
    }
}
