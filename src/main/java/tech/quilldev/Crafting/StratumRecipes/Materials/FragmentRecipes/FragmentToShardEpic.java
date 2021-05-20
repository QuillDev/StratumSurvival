package tech.quilldev.Crafting.StratumRecipes.Materials.FragmentRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.Crafting.StratumRecipes.Materials.BlockRecipe;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterialManager;

public class FragmentToShardEpic extends BlockRecipe {
    public FragmentToShardEpic(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.FRAGMENT_EPIC, StratumMaterial.SHARD_EPIC);
    }
}
