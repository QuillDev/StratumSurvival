package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugChestplateChain extends JugArmorRecipeBase {
    public CraftJugChestplateChain(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_CHAIN_JUG, materialManager,
                StratumMaterial.CHESTPLATE_CHAIN_HEAVY,
                StratumMaterial.CHESTPLATE_CHAIN_JUG
        );
    }
}
