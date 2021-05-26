package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugHelmetLeather extends JugArmorRecipeBase {
    public CraftJugHelmetLeather(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_LEATHER_JUG, materialManager,
                StratumMaterial.HELMET_LEATHER_HEAVY,
                StratumMaterial.HELMET_LEATHER_JUG
        );
    }
}
