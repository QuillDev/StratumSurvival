package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugHelmetChain extends JugArmorRecipeBase {
    public CraftJugHelmetChain(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_CHAIN_JUG, materialManager,
                StratumMaterial.HELMET_CHAIN_HEAVY,
                StratumMaterial.HELMET_CHAIN_JUG
        );
    }
}
