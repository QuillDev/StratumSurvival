package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugChestplateGold extends JugArmorRecipeBase {
    public CraftJugChestplateGold(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_GOLDEN_JUG, materialManager,
                StratumMaterial.CHESTPLATE_GOLDEN_HEAVY,
                StratumMaterial.CHESTPLATE_GOLDEN_JUG
        );
    }
}
