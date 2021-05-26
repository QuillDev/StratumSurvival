package moe.quill.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugChestplateLeather extends JugArmorRecipeBase {
    public CraftJugChestplateLeather(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_LEATHER_JUG, materialManager,
                StratumMaterial.CHESTPLATE_LEATHER_HEAVY,
                StratumMaterial.CHESTPLATE_LEATHER_JUG
        );
    }
}
