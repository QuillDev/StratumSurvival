package tech.quilldev.Crafting.StratumRecipes.Materials.FragmentRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.Crafting.StratumRecipes.Materials.BlockRecipe;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;

public class FragmentToShardRare extends BlockRecipe {
    public FragmentToShardRare(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.FRAGMENT_RARE, StratumMaterial.SHARD_RARE);
    }
}
