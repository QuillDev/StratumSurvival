package moe.quill.Crafting.StratumRecipes.Weapons.Scythes;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Weapons.AbstractRecipes.CobbleRecipe;
import org.bukkit.inventory.RecipeChoice;

public class CraftScytheStone extends ScytheRecipeBase implements CobbleRecipe {
    public CraftScytheStone(RecipeKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, choice, StratumMaterial.SCYTHE_WOODEN);
    }
}
