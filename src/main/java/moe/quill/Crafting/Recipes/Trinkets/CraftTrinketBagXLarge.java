package moe.quill.Crafting.Recipes.Trinkets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.inventory.RecipeChoice;

public class CraftTrinketBagXLarge extends TrinketBagUpgrade{
    public CraftTrinketBagXLarge(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_TRINKET_BAG_XLARGE,
                materialManager,
                StratumMaterial.TRINKET_BAG_XLARGE,
                new RecipeChoice.ExactChoice(materialManager.getItem(StratumMaterial.TRINKET_BAG_LARGE)),
                new RecipeChoice.ExactChoice(materialManager.getItem(StratumMaterial.SHARD_LEGENDARY))
        );
    }
}