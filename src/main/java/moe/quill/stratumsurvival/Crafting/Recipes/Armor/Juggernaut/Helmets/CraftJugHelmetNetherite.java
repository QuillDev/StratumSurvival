package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugHelmetNetherite extends JugArmorRecipeBase {
    public CraftJugHelmetNetherite(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_NETHERITE_JUG, materialManager,
                StratumMaterial.HELMET_NETHERITE_HEAVY,
                StratumMaterial.HELMET_NETHERITE_JUG
        );
    }
}
