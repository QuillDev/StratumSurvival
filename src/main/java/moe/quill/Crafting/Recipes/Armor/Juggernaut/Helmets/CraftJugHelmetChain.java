package moe.quill.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugHelmetChain extends JugArmorRecipeBase {
    public CraftJugHelmetChain(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_CHAIN_JUG, materialManager,
                StratumMaterial.HELMET_CHAIN_HEAVY,
                StratumMaterial.HELMET_CHAIN_JUG
        );
    }
}
