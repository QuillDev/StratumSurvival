package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Leggings;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugLeggingsIron extends JugArmorRecipeBase {
    public CraftJugLeggingsIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_IRON_JUG, materialManager,
                StratumMaterial.LEGGINGS_IRON_HEAVY,
                StratumMaterial.LEGGINGS_IRON_JUG
        );
    }
}
