package moe.quill.Crafting.Recipes.Armor.Juggernaut.Chestplates;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.Juggernaut.JugArmorRecipeBase;

public class CraftJugChestplateIron extends JugArmorRecipeBase {
    public CraftJugChestplateIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CHESTPLATE_IRON_JUG, materialManager,
                StratumMaterial.CHESTPLATE_IRON_HEAVY,
                StratumMaterial.CHESTPLATE_IRON_JUG
        );
    }
}
