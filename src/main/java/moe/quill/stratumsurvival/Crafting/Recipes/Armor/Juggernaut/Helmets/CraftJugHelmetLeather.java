package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugHelmetLeather extends JugArmorRecipeBase {
    public CraftJugHelmetLeather(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_LEATHER_JUG, materialManager,
                StratumMaterial.HELMET_LEATHER_HEAVY,
                StratumMaterial.HELMET_LEATHER_JUG
        );
    }
}
