package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugBootsNetherite extends JugArmorRecipeBase {
    public CraftJugBootsNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_NETHERITE_JUG, materialManager,
                StratumMaterial.BOOTS_NETHERITE_HEAVY,
                StratumMaterial.BOOTS_NETHERITE_JUG
        );
    }
}
