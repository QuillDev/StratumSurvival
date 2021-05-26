package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugLeggingsNetherite extends JugArmorRecipeBase {
    public CraftJugLeggingsNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_NETHERITE_JUG, materialManager,
                StratumMaterial.LEGGINGS_NETHERITE_HEAVY,
                StratumMaterial.LEGGINGS_NETHERITE_JUG
        );
    }
}
