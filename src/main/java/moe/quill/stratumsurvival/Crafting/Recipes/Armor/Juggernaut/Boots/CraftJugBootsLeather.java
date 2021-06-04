package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugBootsLeather extends JugArmorRecipeBase {
    public CraftJugBootsLeather(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_LEATHER_JUG, materialManager,
                StratumMaterial.BOOTS_LEATHER_HEAVY,
                StratumMaterial.BOOTS_LEATHER_JUG
        );
    }
}
