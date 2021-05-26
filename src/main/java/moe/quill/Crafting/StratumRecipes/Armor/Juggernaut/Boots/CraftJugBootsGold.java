package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugBootsGold extends JugArmorRecipeBase {
    public CraftJugBootsGold(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_GOLDEN_JUG, materialManager,
                StratumMaterial.BOOTS_GOLDEN_HEAVY,
                StratumMaterial.BOOTS_GOLDEN_JUG
        );
    }
}
