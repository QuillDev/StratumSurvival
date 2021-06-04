package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugHelmetDiamond extends JugArmorRecipeBase {
    public CraftJugHelmetDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_DIAMOND_JUG, materialManager,
                StratumMaterial.HELMET_DIAMOND_HEAVY,
                StratumMaterial.HELMET_DIAMOND_JUG
        );
    }
}
