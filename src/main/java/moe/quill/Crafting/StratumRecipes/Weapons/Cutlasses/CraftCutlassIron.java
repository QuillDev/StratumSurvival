package moe.quill.Crafting.StratumRecipes.Weapons.Cutlasses;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftCutlassIron extends CutlassRecipeBase {
    public CraftCutlassIron(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_IRON, materialManager, new RecipeChoice.MaterialChoice(Material.IRON_INGOT), StratumMaterial.CUTLASS_IRON);
    }
}
