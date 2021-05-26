package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugChestplateDiamond extends JugArmorRecipeBase {
    public CraftJugChestplateDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_DIAMOND_JUG, materialManager,
                StratumMaterial.CHESTPLATE_DIAMOND_HEAVY,
                StratumMaterial.CHESTPLATE_DIAMOND_JUG
        );
    }
}
