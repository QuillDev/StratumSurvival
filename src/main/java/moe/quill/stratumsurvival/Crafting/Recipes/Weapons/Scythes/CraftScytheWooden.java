package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Scythes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.Weapons.AbstractRecipes.WoodRecipe;

public class CraftScytheWooden extends ScytheRecipeBase implements WoodRecipe {

    public CraftScytheWooden(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_WOODEN, materialManager, choice, StratumMaterial.SCYTHE_WOODEN);
    }
}
