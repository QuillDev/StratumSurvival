package moe.quill.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.Crafting.Recipes.RecipeKey;

public class CraftJugBootsDiamond extends JugArmorRecipeBase {
    public CraftJugBootsDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_DIAMOND_JUG, materialManager,
                StratumMaterial.BOOTS_DIAMOND_HEAVY,
                StratumMaterial.BOOTS_DIAMOND_JUG
        );
    }
}
