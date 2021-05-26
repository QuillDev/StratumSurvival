package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugLeggingsLeather extends JugArmorRecipeBase {
    public CraftJugLeggingsLeather(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_LEATHER_JUG, materialManager,
                StratumMaterial.LEGGINGS_LEATHER_HEAVY,
                StratumMaterial.LEGGINGS_LEATHER_JUG
        );
    }
}
