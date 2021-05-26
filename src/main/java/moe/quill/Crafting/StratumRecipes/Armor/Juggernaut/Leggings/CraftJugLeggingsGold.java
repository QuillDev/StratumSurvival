package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugLeggingsGold extends JugArmorRecipeBase {
    public CraftJugLeggingsGold(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_GOLDEN_JUG, materialManager,
                StratumMaterial.LEGGINGS_GOLDEN_HEAVY,
                StratumMaterial.LEGGINGS_GOLDEN_JUG
        );
    }
}
