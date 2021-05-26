package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugLeggingsIron extends JugArmorRecipeBase {
    public CraftJugLeggingsIron(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_IRON_JUG, materialManager,
                StratumMaterial.LEGGINGS_IRON_HEAVY,
                StratumMaterial.LEGGINGS_IRON_JUG
        );
    }
}
