package moe.quill.Crafting.Recipes.Trinkets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.inventory.RecipeChoice;

public class CraftTrinketBagLarge extends TrinketBagUpgrade{
    public CraftTrinketBagLarge(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_TRINKET_BAG_LARGE,
                materialManager,
                StratumMaterial.TRINKET_BAG_LARGE,
                new RecipeChoice.ExactChoice(materialManager.getItem(StratumMaterial.TRINKET_BAG_MEDIUM)),
                new RecipeChoice.ExactChoice(materialManager.getItem(StratumMaterial.SHARD_LEGENDARY))
        );
    }
}
