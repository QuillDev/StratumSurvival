package moe.quill.stratumsurvival.Crafting.Recipes.Weapons.Cutlasses;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftCutlassDiamond extends CutlassRecipeBase {
    public CraftCutlassDiamond(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_DIAMOND, materialManager, new RecipeChoice.MaterialChoice(Material.DIAMOND), StratumMaterial.CUTLASS_DIAMOND);
    }
}
