package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Helmets;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugHelmetIron extends JugArmorRecipeBase {
    public CraftJugHelmetIron(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_HELMET_IRON_JUG, materialManager,
                StratumMaterial.HELMET_IRON_HEAVY,
                StratumMaterial.HELMET_IRON_JUG
        );
    }
}
