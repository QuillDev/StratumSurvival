package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugBootsNetherite extends JugArmorRecipeBase {
    public CraftJugBootsNetherite(RecipeKey key, StratumMaterialManager materialManager) {
        super(key, materialManager,
                StratumMaterial.BOOTS_NETHERITE_HEAVY,
                StratumMaterial.BOOTS_NETHERITE_JUG
        );
    }
}
