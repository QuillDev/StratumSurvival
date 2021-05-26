package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugChestplateNetherite extends JugArmorRecipeBase {
    public CraftJugChestplateNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_NETHERITE_JUG, materialManager,
                StratumMaterial.CHESTPLATE_NETHERITE_HEAVY,
                StratumMaterial.CHESTPLATE_NETHERITE_JUG
        );
    }
}
