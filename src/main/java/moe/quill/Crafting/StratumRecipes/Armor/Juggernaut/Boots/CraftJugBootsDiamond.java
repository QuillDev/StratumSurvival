package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugBootsDiamond extends JugArmorRecipeBase {
    public CraftJugBootsDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_DIAMOND_JUG, materialManager,
                StratumMaterial.BOOTS_DIAMOND_HEAVY,
                StratumMaterial.BOOTS_DIAMOND_JUG
        );
    }
}
