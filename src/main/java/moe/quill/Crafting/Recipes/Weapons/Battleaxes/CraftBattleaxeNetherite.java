package moe.quill.Crafting.Recipes.Weapons.Battleaxes;

import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.Weapons.AbstractRecipes.StratumSmithRecipe;

public class CraftBattleaxeNetherite extends StratumSmithRecipe {
    public CraftBattleaxeNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BATTLEAXE_NETHERITE, materialManager, StratumMaterial.BATTLEAXE_DIAMOND, StratumMaterial.BATTLEAXE_NETHERITE);
    }
}
