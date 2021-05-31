package moe.quill.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.Crafting.Recipes.RecipeKey;

public class CraftJugChestplateNetherite extends JugArmorRecipeBase {
    public CraftJugChestplateNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_NETHERITE_JUG, materialManager,
                StratumMaterial.CHESTPLATE_NETHERITE_HEAVY,
                StratumMaterial.CHESTPLATE_NETHERITE_JUG
        );
    }
}
