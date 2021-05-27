package moe.quill.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugBootsDiamond extends JugArmorRecipeBase {
    public CraftJugBootsDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_DIAMOND_JUG, materialManager,
                StratumMaterial.BOOTS_DIAMOND_HEAVY,
                StratumMaterial.BOOTS_DIAMOND_JUG
        );
    }
}