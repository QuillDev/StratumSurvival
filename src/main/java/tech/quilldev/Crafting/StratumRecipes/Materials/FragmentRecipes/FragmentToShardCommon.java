package tech.quilldev.Crafting.StratumRecipes.Materials.FragmentRecipes;

import org.bukkit.NamespacedKey;
import tech.quilldev.Crafting.StratumRecipes.Materials.BlockRecipe;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class FragmentToShardCommon extends BlockRecipe {

    public FragmentToShardCommon(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.FRAGMENT_COMMON, StratumMaterial.SHARD_COMMON);
    }
}
