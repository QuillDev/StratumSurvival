package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugHelmetGold extends JugArmorRecipeBase {
    public CraftJugHelmetGold(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_GOLDEN_JUG, materialManager,
                StratumMaterial.HELMET_GOLDEN_HEAVY,
                StratumMaterial.HELMET_GOLDEN_JUG
        );
    }
}
