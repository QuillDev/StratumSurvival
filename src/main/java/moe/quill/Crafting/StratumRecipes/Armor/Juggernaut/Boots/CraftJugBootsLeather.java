package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugBootsLeather extends JugArmorRecipeBase {
    public CraftJugBootsLeather(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_LEATHER_JUG, materialManager,
                StratumMaterial.BOOTS_LEATHER_HEAVY,
                StratumMaterial.BOOTS_LEATHER_JUG
        );
    }
}
