package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Leggings;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugLeggingsChain extends JugArmorRecipeBase {
    public CraftJugLeggingsChain(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_CHAIN_JUG, materialManager,
                StratumMaterial.LEGGINGS_CHAIN_HEAVY,
                StratumMaterial.LEGGINGS_CHAIN_JUG
        );
    }
}
