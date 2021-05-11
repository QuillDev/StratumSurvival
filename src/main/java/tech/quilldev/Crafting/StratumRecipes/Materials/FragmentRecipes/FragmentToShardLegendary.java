package tech.quilldev.Crafting.StratumRecipes.Materials.FragmentRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.Crafting.StratumRecipes.Materials.BlockRecipe;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;

public class FragmentToShardLegendary extends BlockRecipe {

    public FragmentToShardLegendary(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.FRAGMENT_LEGENDARY, StratumMaterial.SHARD_LEGENDARY);
    }
}
