package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugHelmetGold extends JugArmorRecipeBase {
    public CraftJugHelmetGold(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_GOLDEN_JUG, materialManager,
                StratumMaterial.HELMET_GOLDEN_HEAVY,
                StratumMaterial.HELMET_GOLDEN_JUG
        );
    }
}
