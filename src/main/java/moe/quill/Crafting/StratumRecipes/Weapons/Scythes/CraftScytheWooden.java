package moe.quill.Crafting.StratumRecipes.Weapons.Scythes;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Weapons.AbstractRecipes.WoodRecipe;

public class CraftScytheWooden extends ScytheRecipeBase implements WoodRecipe {

    public CraftScytheWooden(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_WOODEN, materialManager, choice, StratumMaterial.SCYTHE_WOODEN);
    }
}
