package moe.quill.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.Crafting.Recipes.RecipeKey;

public class CraftJugChestplateLeather extends JugArmorRecipeBase {
    public CraftJugChestplateLeather(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_LEATHER_JUG, materialManager,
                StratumMaterial.CHESTPLATE_LEATHER_HEAVY,
                StratumMaterial.CHESTPLATE_LEATHER_JUG
        );
    }
}
