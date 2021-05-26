package moe.quill.Crafting.StratumRecipes.Weapons.Cutlasses;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Weapons.AbstractRecipes.StratumSmithRecipe;

public class CraftCutlassNetherite extends StratumSmithRecipe {
    public CraftCutlassNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_NETHERITE, materialManager, StratumMaterial.CUTLASS_DIAMOND, StratumMaterial.CUTLASS_NETHERITE);
    }
}
