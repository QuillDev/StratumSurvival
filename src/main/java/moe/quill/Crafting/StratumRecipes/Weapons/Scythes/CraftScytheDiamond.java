package moe.quill.Crafting.StratumRecipes.Weapons.Scythes;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class CraftScytheDiamond extends ScytheRecipeBase {
    public CraftScytheDiamond(RecipeKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, new RecipeChoice.MaterialChoice(Material.DIAMOND), StratumMaterial.SCYTHE_DIAMOND);
    }
}
