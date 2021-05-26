package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugHelmetChain extends JugArmorRecipeBase {
    public CraftJugHelmetChain(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_CHAIN_JUG, materialManager,
                StratumMaterial.HELMET_CHAIN_HEAVY,
                StratumMaterial.HELMET_CHAIN_JUG
        );
    }
}
