package moe.quill.Crafting.StratumRecipes.Weapons.Scythes;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftScytheGolden extends ScytheRecipeBase {
    public CraftScytheGolden(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_GOLDEN, materialManager, new RecipeChoice.MaterialChoice(Material.GOLD_INGOT), StratumMaterial.SCYTHE_GOLDEN);
    }
}
