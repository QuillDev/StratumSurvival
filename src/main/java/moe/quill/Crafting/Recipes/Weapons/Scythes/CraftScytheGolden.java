package moe.quill.Crafting.Recipes.Weapons.Scythes;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftScytheGolden extends ScytheRecipeBase {
    public CraftScytheGolden(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_GOLDEN, materialManager, new RecipeChoice.MaterialChoice(Material.GOLD_INGOT), StratumMaterial.SCYTHE_GOLDEN);
    }
}
