package moe.quill.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugChestplateChain extends JugArmorRecipeBase {
    public CraftJugChestplateChain(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_CHAIN_JUG, materialManager,
                StratumMaterial.CHESTPLATE_CHAIN_HEAVY,
                StratumMaterial.CHESTPLATE_CHAIN_JUG
        );
    }
}
