package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Leggings;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugLeggingsLeather extends JugArmorRecipeBase {
    public CraftJugLeggingsLeather(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_LEATHER_JUG, materialManager,
                StratumMaterial.LEGGINGS_LEATHER_HEAVY,
                StratumMaterial.LEGGINGS_LEATHER_JUG
        );
    }
}
