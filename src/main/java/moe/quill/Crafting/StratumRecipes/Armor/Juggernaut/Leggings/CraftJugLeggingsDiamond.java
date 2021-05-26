package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugLeggingsDiamond extends JugArmorRecipeBase {
    public CraftJugLeggingsDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_DIAMOND_JUG, materialManager,
                StratumMaterial.LEGGINGS_DIAMOND_HEAVY,
                StratumMaterial.LEGGINGS_DIAMOND_JUG
        );
    }
}
