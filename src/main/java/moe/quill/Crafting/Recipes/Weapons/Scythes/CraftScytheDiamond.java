package moe.quill.Crafting.Recipes.Weapons.Scythes;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftScytheDiamond extends ScytheRecipeBase {
    public CraftScytheDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_DIAMOND, materialManager, new RecipeChoice.MaterialChoice(Material.DIAMOND), StratumMaterial.SCYTHE_DIAMOND);
    }
}
