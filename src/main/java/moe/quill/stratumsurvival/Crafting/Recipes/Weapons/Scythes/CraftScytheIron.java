package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Scythes;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftScytheIron extends ScytheRecipeBase {
    public CraftScytheIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_IRON, materialManager, new RecipeChoice.MaterialChoice(Material.IRON_INGOT), StratumMaterial.SCYTHE_IRON);
    }
}
