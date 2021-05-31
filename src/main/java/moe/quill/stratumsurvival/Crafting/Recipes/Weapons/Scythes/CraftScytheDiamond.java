package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Scythes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftScytheDiamond extends ScytheRecipeBase {
    public CraftScytheDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_DIAMOND, materialManager, new RecipeChoice.MaterialChoice(Material.DIAMOND), StratumMaterial.SCYTHE_DIAMOND);
    }
}
