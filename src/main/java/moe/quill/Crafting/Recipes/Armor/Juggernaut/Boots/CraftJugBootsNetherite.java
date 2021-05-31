package moe.quill.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.Crafting.Recipes.RecipeKey;

public class CraftJugBootsNetherite extends JugArmorRecipeBase {
    public CraftJugBootsNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_NETHERITE_JUG, materialManager,
                StratumMaterial.BOOTS_NETHERITE_HEAVY,
                StratumMaterial.BOOTS_NETHERITE_JUG
        );
    }
}
