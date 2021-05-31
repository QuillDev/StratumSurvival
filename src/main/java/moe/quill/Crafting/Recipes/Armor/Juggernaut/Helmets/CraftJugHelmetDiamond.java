package moe.quill.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.Crafting.Recipes.RecipeKey;

public class CraftJugHelmetDiamond extends JugArmorRecipeBase {
    public CraftJugHelmetDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_DIAMOND_JUG, materialManager,
                StratumMaterial.HELMET_DIAMOND_HEAVY,
                StratumMaterial.HELMET_DIAMOND_JUG
        );
    }
}
