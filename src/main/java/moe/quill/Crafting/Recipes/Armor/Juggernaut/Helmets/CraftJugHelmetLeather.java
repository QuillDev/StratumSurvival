package moe.quill.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugHelmetLeather extends JugArmorRecipeBase {
    public CraftJugHelmetLeather(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_LEATHER_JUG, materialManager,
                StratumMaterial.HELMET_LEATHER_HEAVY,
                StratumMaterial.HELMET_LEATHER_JUG
        );
    }
}
