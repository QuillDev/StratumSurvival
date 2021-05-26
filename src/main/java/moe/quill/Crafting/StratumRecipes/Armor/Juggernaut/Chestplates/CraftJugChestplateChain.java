package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugChestplateChain extends JugArmorRecipeBase {
    public CraftJugChestplateChain(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_CHAIN_JUG, materialManager,
                StratumMaterial.CHESTPLATE_CHAIN_HEAVY,
                StratumMaterial.CHESTPLATE_CHAIN_JUG
        );
    }
}
