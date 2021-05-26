package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugBootsChain extends JugArmorRecipeBase {
    public CraftJugBootsChain(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_CHAIN_JUG, materialManager,
                StratumMaterial.BOOTS_CHAIN_HEAVY,
                StratumMaterial.BOOTS_CHAIN_JUG
        );
    }
}
