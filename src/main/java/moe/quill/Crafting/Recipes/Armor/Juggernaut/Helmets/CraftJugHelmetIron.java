package moe.quill.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;
import moe.quill.Crafting.Recipes.RecipeKey;

public class CraftJugHelmetIron extends JugArmorRecipeBase {
    public CraftJugHelmetIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_IRON_JUG, materialManager,
                StratumMaterial.HELMET_IRON_HEAVY,
                StratumMaterial.HELMET_IRON_JUG
        );
    }
}
