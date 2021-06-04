package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Cutlasses;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftCutlassIron extends CutlassRecipeBase {
    public CraftCutlassIron(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_IRON, materialManager, new RecipeChoice.MaterialChoice(Material.IRON_INGOT), StratumMaterial.CUTLASS_IRON);
    }
}
