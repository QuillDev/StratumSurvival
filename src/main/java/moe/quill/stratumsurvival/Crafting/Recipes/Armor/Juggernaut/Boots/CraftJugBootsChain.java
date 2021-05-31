package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugBootsChain extends JugArmorRecipeBase {
    public CraftJugBootsChain(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_CHAIN_JUG, materialManager,
                StratumMaterial.BOOTS_CHAIN_HEAVY,
                StratumMaterial.BOOTS_CHAIN_JUG
        );
    }
}
