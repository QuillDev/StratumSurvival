package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugBootsIron extends JugArmorRecipeBase {
    public CraftJugBootsIron(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_IRON_JUG, materialManager,
                StratumMaterial.BOOTS_IRON_HEAVY,
                StratumMaterial.BOOTS_IRON_JUG
        );
    }
}
