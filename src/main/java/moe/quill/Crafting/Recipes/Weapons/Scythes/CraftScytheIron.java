package moe.quill.Crafting.Recipes.Weapons.Scythes;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftScytheIron extends ScytheRecipeBase {
    public CraftScytheIron(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_SCYTHE_IRON, materialManager, new RecipeChoice.MaterialChoice(Material.IRON_INGOT), StratumMaterial.SCYTHE_IRON);
    }
}
