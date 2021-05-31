package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugChestplateLeather extends JugArmorRecipeBase {
    public CraftJugChestplateLeather(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_LEATHER_JUG, materialManager,
                StratumMaterial.CHESTPLATE_LEATHER_HEAVY,
                StratumMaterial.CHESTPLATE_LEATHER_JUG
        );
    }
}
