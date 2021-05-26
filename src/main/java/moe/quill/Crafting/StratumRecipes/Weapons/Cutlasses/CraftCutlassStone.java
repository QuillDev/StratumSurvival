package moe.quill.Crafting.StratumRecipes.Weapons.Cutlasses;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Weapons.AbstractRecipes.StoneRecipe;

public class CraftCutlassStone extends CutlassRecipeBase implements StoneRecipe {
    public CraftCutlassStone(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_STONE, materialManager, choice, StratumMaterial.CUTLASS_STONE);
    }
}
