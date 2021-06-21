package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.TrinketRegestries;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.GlobalKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;

public abstract class TrinketRegistry extends MaterialRegistry {
    public TrinketRegistry(IKeyManager keyManager, ISerializer serializer, MaterialKey materialKey) {
        super(keyManager, serializer, materialKey, GlobalKey.IS_TRINKET);
    }
}
