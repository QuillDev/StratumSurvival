package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Scythes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import moe.quill.stratumsurvival.Crafting.Recipes.Weapons.AbstractRecipes.StoneRecipe;

public class CraftScytheStone extends ScytheRecipeBase implements StoneRecipe {
    public CraftScytheStone(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_STONE, materialManager, choice, StratumMaterial.SCYTHE_STONE);
    }
}
