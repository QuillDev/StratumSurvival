package moe.quill.Crafting.Recipes.Weapons.Cutlasses;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftCutlassGolden extends CutlassRecipeBase {
    public CraftCutlassGolden(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_CUTLASS_GOLDEN, materialManager, new RecipeChoice.MaterialChoice(Material.GOLD_INGOT), StratumMaterial.CUTLASS_GOLDEN);
    }
}
