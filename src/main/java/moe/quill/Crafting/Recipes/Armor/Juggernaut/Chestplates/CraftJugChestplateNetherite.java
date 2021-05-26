package moe.quill.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugChestplateNetherite extends JugArmorRecipeBase {
    public CraftJugChestplateNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_NETHERITE_JUG, materialManager,
                StratumMaterial.CHESTPLATE_NETHERITE_HEAVY,
                StratumMaterial.CHESTPLATE_NETHERITE_JUG
        );
    }
}
