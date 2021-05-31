package moe.quill.Crafting.Recipes.Weapons.Scythes;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftScytheDiamond extends ScytheRecipeBase {
    public CraftScytheDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_DIAMOND, materialManager, new RecipeChoice.MaterialChoice(Material.DIAMOND), StratumMaterial.SCYTHE_DIAMOND);
    }
}
