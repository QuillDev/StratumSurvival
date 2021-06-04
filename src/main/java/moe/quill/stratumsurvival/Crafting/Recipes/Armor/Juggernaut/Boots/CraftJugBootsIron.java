package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugBootsIron extends JugArmorRecipeBase {
    public CraftJugBootsIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_IRON_JUG, materialManager,
                StratumMaterial.BOOTS_IRON_HEAVY,
                StratumMaterial.BOOTS_IRON_JUG
        );
    }
}
