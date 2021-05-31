package moe.quill.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.Crafting.Recipes.RecipeKey;

public class CraftJugChestplateDiamond extends JugArmorRecipeBase {
    public CraftJugChestplateDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_DIAMOND_JUG, materialManager,
                StratumMaterial.CHESTPLATE_DIAMOND_HEAVY,
                StratumMaterial.CHESTPLATE_DIAMOND_JUG
        );
    }
}
