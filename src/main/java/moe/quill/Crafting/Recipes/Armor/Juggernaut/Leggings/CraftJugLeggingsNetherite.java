package moe.quill.Crafting.Recipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugLeggingsNetherite extends JugArmorRecipeBase {
    public CraftJugLeggingsNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_NETHERITE_JUG, materialManager,
                StratumMaterial.LEGGINGS_NETHERITE_HEAVY,
                StratumMaterial.LEGGINGS_NETHERITE_JUG
        );
    }
}
