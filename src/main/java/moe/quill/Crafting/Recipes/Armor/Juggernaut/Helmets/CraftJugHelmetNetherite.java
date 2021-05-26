package moe.quill.Crafting.Recipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugHelmetNetherite extends JugArmorRecipeBase {
    public CraftJugHelmetNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_NETHERITE_JUG, materialManager,
                StratumMaterial.HELMET_NETHERITE_HEAVY,
                StratumMaterial.HELMET_NETHERITE_JUG
        );
    }
}
