package moe.quill.Crafting.Recipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugLeggingsChain extends JugArmorRecipeBase {
    public CraftJugLeggingsChain(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_CHAIN_JUG, materialManager,
                StratumMaterial.LEGGINGS_CHAIN_HEAVY,
                StratumMaterial.LEGGINGS_CHAIN_JUG
        );
    }
}
