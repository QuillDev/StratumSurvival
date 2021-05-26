package moe.quill.Crafting.Recipes.Weapons.Cutlasses;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftCutlassDiamond extends CutlassRecipeBase {
    public CraftCutlassDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_DIAMOND, materialManager, new RecipeChoice.MaterialChoice(Material.DIAMOND), StratumMaterial.CUTLASS_DIAMOND);
    }
}
