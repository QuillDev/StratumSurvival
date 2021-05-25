package moe.quill.Crafting.StratumRecipes.Weapons.Scythes;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Weapons.AbstractRecipes.StoneRecipe;

public class CraftScytheStone extends ScytheRecipeBase implements StoneRecipe {
    public CraftScytheStone(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_STONE, materialManager, choice, StratumMaterial.SCYTHE_STONE);
    }
}
