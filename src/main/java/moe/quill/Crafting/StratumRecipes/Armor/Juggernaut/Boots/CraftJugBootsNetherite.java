package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugBootsNetherite extends JugArmorRecipeBase {
    public CraftJugBootsNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_NETHERITE_JUG, materialManager,
                StratumMaterial.BOOTS_NETHERITE_HEAVY,
                StratumMaterial.BOOTS_NETHERITE_JUG
        );
    }
}
