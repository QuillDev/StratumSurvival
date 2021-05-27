package moe.quill.Crafting.Recipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugLeggingsLeather extends JugArmorRecipeBase {
    public CraftJugLeggingsLeather(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_LEATHER_JUG, materialManager,
                StratumMaterial.LEGGINGS_LEATHER_HEAVY,
                StratumMaterial.LEGGINGS_LEATHER_JUG
        );
    }
}
