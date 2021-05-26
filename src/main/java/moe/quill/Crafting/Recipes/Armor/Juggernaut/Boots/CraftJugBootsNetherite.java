package moe.quill.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugBootsNetherite extends JugArmorRecipeBase {
    public CraftJugBootsNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_NETHERITE_JUG, materialManager,
                StratumMaterial.BOOTS_NETHERITE_HEAVY,
                StratumMaterial.BOOTS_NETHERITE_JUG
        );
    }
}
