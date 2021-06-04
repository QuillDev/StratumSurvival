package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugHelmetIron extends JugArmorRecipeBase {
    public CraftJugHelmetIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_IRON_JUG, materialManager,
                StratumMaterial.HELMET_IRON_HEAVY,
                StratumMaterial.HELMET_IRON_JUG
        );
    }
}
