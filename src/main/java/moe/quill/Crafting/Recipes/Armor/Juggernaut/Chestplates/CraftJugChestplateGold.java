package moe.quill.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugChestplateGold extends JugArmorRecipeBase {
    public CraftJugChestplateGold(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_GOLDEN_JUG, materialManager,
                StratumMaterial.CHESTPLATE_GOLDEN_HEAVY,
                StratumMaterial.CHESTPLATE_GOLDEN_JUG
        );
    }
}
