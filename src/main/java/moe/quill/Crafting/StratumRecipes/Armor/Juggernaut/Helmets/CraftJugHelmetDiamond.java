package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugHelmetDiamond extends JugArmorRecipeBase {
    public CraftJugHelmetDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_DIAMOND_JUG, materialManager,
                StratumMaterial.HELMET_DIAMOND_HEAVY,
                StratumMaterial.HELMET_DIAMOND_JUG
        );
    }
}
