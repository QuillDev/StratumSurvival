package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugChestplateLeather extends JugArmorRecipeBase {
    public CraftJugChestplateLeather(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_LEATHER_JUG, materialManager,
                StratumMaterial.CHESTPLATE_LEATHER_HEAVY,
                StratumMaterial.CHESTPLATE_LEATHER_JUG
        );
    }
}
