package moe.quill.Crafting.Recipes.Armor.Juggernaut.Leggings;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugLeggingsIron extends JugArmorRecipeBase {
    public CraftJugLeggingsIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_LEGGINGS_IRON_JUG, materialManager,
                StratumMaterial.LEGGINGS_IRON_HEAVY,
                StratumMaterial.LEGGINGS_IRON_JUG
        );
    }
}
