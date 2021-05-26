package moe.quill.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugHelmetDiamond extends JugArmorRecipeBase {
    public CraftJugHelmetDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_DIAMOND_JUG, materialManager,
                StratumMaterial.HELMET_DIAMOND_HEAVY,
                StratumMaterial.HELMET_DIAMOND_JUG
        );
    }
}
