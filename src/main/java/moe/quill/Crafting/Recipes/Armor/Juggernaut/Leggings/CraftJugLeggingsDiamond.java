package moe.quill.Crafting.Recipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.Crafting.Recipes.RecipeKey;

public class CraftJugLeggingsDiamond extends JugArmorRecipeBase {
    public CraftJugLeggingsDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_DIAMOND_JUG, materialManager,
                StratumMaterial.LEGGINGS_DIAMOND_HEAVY,
                StratumMaterial.LEGGINGS_DIAMOND_JUG
        );
    }
}
