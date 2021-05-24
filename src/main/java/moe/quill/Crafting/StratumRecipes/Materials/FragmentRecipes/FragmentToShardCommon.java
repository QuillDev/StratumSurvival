package moe.quill.Crafting.StratumRecipes.Materials.FragmentRecipes;

import org.bukkit.NamespacedKey;
import moe.quill.Crafting.StratumRecipes.Materials.BlockRecipe;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class FragmentToShardCommon extends BlockRecipe {

    public FragmentToShardCommon(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.FRAGMENT_COMMON, StratumMaterial.SHARD_COMMON);
    }
}
