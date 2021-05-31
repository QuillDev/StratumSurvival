package moe.quill.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.Crafting.Recipes.RecipeKey;

public class CraftJugBootsGold extends JugArmorRecipeBase {
    public CraftJugBootsGold(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_GOLDEN_JUG, materialManager,
                StratumMaterial.BOOTS_GOLDEN_HEAVY,
                StratumMaterial.BOOTS_GOLDEN_JUG
        );
    }
}
