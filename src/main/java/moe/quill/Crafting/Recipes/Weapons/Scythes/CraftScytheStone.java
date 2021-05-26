package moe.quill.Crafting.Recipes.Weapons.Scythes;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Weapons.AbstractRecipes.StoneRecipe;

public class CraftScytheStone extends ScytheRecipeBase implements StoneRecipe {
    public CraftScytheStone(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_STONE, materialManager, choice, StratumMaterial.SCYTHE_STONE);
    }
}
