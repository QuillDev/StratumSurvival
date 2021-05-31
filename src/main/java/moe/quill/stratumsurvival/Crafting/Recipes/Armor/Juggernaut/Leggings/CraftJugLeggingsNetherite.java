package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Leggings;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugLeggingsNetherite extends JugArmorRecipeBase {
    public CraftJugLeggingsNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_NETHERITE_JUG, materialManager,
                StratumMaterial.LEGGINGS_NETHERITE_HEAVY,
                StratumMaterial.LEGGINGS_NETHERITE_JUG
        );
    }
}
