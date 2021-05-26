package moe.quill.Crafting.StratumRecipes.Weapons.Cutlasses;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftCutlassDiamond extends CutlassRecipeBase {
    public CraftCutlassDiamond(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_DIAMOND, materialManager, new RecipeChoice.MaterialChoice(Material.DIAMOND), StratumMaterial.CUTLASS_DIAMOND);
    }
}
