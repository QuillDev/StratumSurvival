package moe.quill.Crafting.Recipes.Weapons.Scythes;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Weapons.AbstractRecipes.StratumSmithRecipe;

public class CraftScytheNetherite extends StratumSmithRecipe {

    public CraftScytheNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_NETHERITE, materialManager, StratumMaterial.SCYTHE_DIAMOND, StratumMaterial.SCYTHE_NETHERITE);
    }
}