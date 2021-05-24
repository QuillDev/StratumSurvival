package moe.quill.Crafting.StratumRecipes.Materials.FragmentRecipes;

import org.bukkit.NamespacedKey;
import moe.quill.Crafting.StratumRecipes.Materials.BlockRecipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class FragmentToShardEpic extends BlockRecipe {
    public FragmentToShardEpic(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager, StratumMaterial.FRAGMENT_EPIC, StratumMaterial.SHARD_EPIC);
    }
}
