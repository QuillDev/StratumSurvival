package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;

public class CraftJugChestplateIron extends JugArmorRecipeBase {
    public CraftJugChestplateIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_IRON_JUG, materialManager,
                StratumMaterial.CHESTPLATE_IRON_HEAVY,
                StratumMaterial.CHESTPLATE_IRON_JUG
        );
    }
}
