package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugLeggingsChain extends JugArmorRecipeBase {
    public CraftJugLeggingsChain(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_CHAIN_JUG, materialManager,
                StratumMaterial.LEGGINGS_CHAIN_HEAVY,
                StratumMaterial.LEGGINGS_CHAIN_JUG
        );
    }
}
