package moe.quill.Crafting.Recipes.Weapons.Cutlasses;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Weapons.AbstractRecipes.StratumSmithRecipe;

public class CraftCutlassNetherite extends StratumSmithRecipe {
    public CraftCutlassNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_NETHERITE, materialManager, StratumMaterial.CUTLASS_DIAMOND, StratumMaterial.CUTLASS_NETHERITE);
    }
}
