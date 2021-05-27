package moe.quill.Crafting.Recipes.Armor.Juggernaut.Boots;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugBootsIron extends JugArmorRecipeBase {
    public CraftJugBootsIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_BOOTS_IRON_JUG, materialManager,
                StratumMaterial.BOOTS_IRON_HEAVY,
                StratumMaterial.BOOTS_IRON_JUG
        );
    }
}
