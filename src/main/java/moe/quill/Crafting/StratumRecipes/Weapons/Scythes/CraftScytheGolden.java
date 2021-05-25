package moe.quill.Crafting.StratumRecipes.Weapons.Scythes;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftScytheGolden extends ScytheRecipeBase {
    public CraftScytheGolden(RecipeKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, new RecipeChoice.MaterialChoice(Material.GOLD_INGOT), StratumMaterial.SCYTHE_GOLDEN);
    }
}
