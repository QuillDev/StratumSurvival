package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugBootsGold extends JugArmorRecipeBase {
    public CraftJugBootsGold(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_GOLDEN_JUG, materialManager,
                StratumMaterial.BOOTS_GOLDEN_HEAVY,
                StratumMaterial.BOOTS_GOLDEN_JUG
        );
    }
}
