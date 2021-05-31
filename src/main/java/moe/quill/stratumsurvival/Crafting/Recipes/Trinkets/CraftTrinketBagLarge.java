package moe.quill.stratumsurvival.Crafting.Recipes.Trinkets;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
import org.bukkit.inventory.RecipeChoice;

public class CraftTrinketBagLarge extends TrinketBagUpgrade{
    public CraftTrinketBagLarge(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_TRINKET_BAG_LARGE,
                materialManager,
                StratumMaterial.TRINKET_BAG_LARGE,
                new RecipeChoice.ExactChoice(materialManager.getItem(StratumMaterial.TRINKET_BAG_MEDIUM)),
                new RecipeChoice.ExactChoice(materialManager.getItem(StratumMaterial.SHARD_EPIC))
        );
    }
}
