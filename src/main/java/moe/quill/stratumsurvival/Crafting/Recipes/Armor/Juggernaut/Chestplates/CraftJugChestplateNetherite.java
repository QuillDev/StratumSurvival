package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugChestplateNetherite extends JugArmorRecipeBase {
    public CraftJugChestplateNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_NETHERITE_JUG, materialManager,
                StratumMaterial.CHESTPLATE_NETHERITE_HEAVY,
                StratumMaterial.CHESTPLATE_NETHERITE_JUG
        );
    }
}
