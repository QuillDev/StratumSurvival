package moe.quill.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugHelmetGold extends JugArmorRecipeBase {
    public CraftJugHelmetGold(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_GOLDEN_JUG, materialManager,
                StratumMaterial.HELMET_GOLDEN_HEAVY,
                StratumMaterial.HELMET_GOLDEN_JUG
        );
    }
}
