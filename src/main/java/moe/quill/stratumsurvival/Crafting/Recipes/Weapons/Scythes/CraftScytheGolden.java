package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Scythes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftScytheGolden extends ScytheRecipeBase {
    public CraftScytheGolden(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_GOLDEN, materialManager, new RecipeChoice.MaterialChoice(Material.GOLD_INGOT), StratumMaterial.SCYTHE_GOLDEN);
    }
}
