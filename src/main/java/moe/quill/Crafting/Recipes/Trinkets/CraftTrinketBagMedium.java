package moe.quill.Crafting.Recipes.Trinkets;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Recipes.RecipeKey;
import org.bukkit.inventory.RecipeChoice;

public class CraftTrinketBagMedium extends TrinketBagUpgrade {
    public CraftTrinketBagMedium(MaterialManager materialManager) {
        super(RecipeKey.RECIPE_TRINKET_BAG_MEDIUM,
                materialManager,
                StratumMaterial.TRINKET_BAG_MEDIUM,
                new RecipeChoice.ExactChoice(materialManager.getItem(StratumMaterial.TRINKET_BAG_SMALL)),
                new RecipeChoice.ExactChoice(materialManager.getItem(StratumMaterial.SHARD_RARE))
        );
    }
}
