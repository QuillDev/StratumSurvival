package moe.quill.Crafting.StratumRecipes.Weapons.Scythes;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Weapons.AbstractRecipes.StratumSmithRecipe;

public class CraftScytheNetherite extends StratumSmithRecipe {

    public CraftScytheNetherite(RecipeKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.SCYTHE_DIAMOND, StratumMaterial.SCYTHE_NETHERITE);
    }
}
