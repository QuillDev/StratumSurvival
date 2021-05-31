package moe.quill.Crafting.Recipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.Crafting.Recipes.RecipeKey;

public class CraftJugLeggingsGold extends JugArmorRecipeBase {
    public CraftJugLeggingsGold(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_GOLDEN_JUG, materialManager,
                StratumMaterial.LEGGINGS_GOLDEN_HEAVY,
                StratumMaterial.LEGGINGS_GOLDEN_JUG
        );
    }
}
