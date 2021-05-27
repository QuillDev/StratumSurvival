package moe.quill.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugBootsChain extends JugArmorRecipeBase {
    public CraftJugBootsChain(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_CHAIN_JUG, materialManager,
                StratumMaterial.BOOTS_CHAIN_HEAVY,
                StratumMaterial.BOOTS_CHAIN_JUG
        );
    }
}
