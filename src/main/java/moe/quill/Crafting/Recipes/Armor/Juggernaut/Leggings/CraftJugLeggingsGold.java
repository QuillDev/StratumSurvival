package moe.quill.Crafting.Recipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugLeggingsGold extends JugArmorRecipeBase {
    public CraftJugLeggingsGold(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_GOLDEN_JUG, materialManager,
                StratumMaterial.LEGGINGS_GOLDEN_HEAVY,
                StratumMaterial.LEGGINGS_GOLDEN_JUG
        );
    }
}
