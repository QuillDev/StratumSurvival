package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugHelmetNetherite extends JugArmorRecipeBase {
    public CraftJugHelmetNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_NETHERITE_JUG, materialManager,
                StratumMaterial.HELMET_NETHERITE_HEAVY,
                StratumMaterial.HELMET_NETHERITE_JUG
        );
    }
}
