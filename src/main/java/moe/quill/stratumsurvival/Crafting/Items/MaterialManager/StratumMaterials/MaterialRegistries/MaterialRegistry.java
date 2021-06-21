package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.GlobalKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public abstract class MaterialRegistry {
    protected MaterialKey materialKey;
    protected IKeyManager keyManager;
    protected ISerializer serializer;
    protected HashSet<Enum<?>> keysToApply = new HashSet<>();

    public MaterialRegistry(IKeyManager keyManager, ISerializer serializer, MaterialKey materialKey) {
        this.keyManager = keyManager;
        this.materialKey = materialKey;
        this.serializer = serializer;

        //Generic keys to add to the item
        keysToApply.addAll(Arrays.asList(
                materialKey,
                GlobalKey.IS_CUSTOM_KEY
        ));
    }

    public MaterialRegistry(IKeyManager keyManager, ISerializer serializer, MaterialKey materialKey, Enum<?>... markerKeys) {
        this(keyManager, serializer, materialKey);
        keysToApply.addAll(Arrays.asList(markerKeys)); //add all of the given marker keys to the keys to apply
    }

    public abstract HashMap<String, ItemStack> getMaterials();

    public MaterialKey getMaterialKey() {
        return materialKey;
    }

    /**
     * Apply all marker keys to each item
     *
     * @param materialList the map of materials from this method
     */
    public void applyMarkerKeys(HashMap<String, ItemStack> materialList) {

        //Apply all of the keys we need to apply
        for (final var key : keysToApply) {

            //Apply this key to each item stack
            for (final var item : materialList.values()) {
                //Apply the key on each item
                final var meta = item.getItemMeta();
                final var data = meta.getPersistentDataContainer();
                data.set(keyManager.getKey(key), PersistentDataType.BYTE_ARRAY, serializer.serializeBoolean(true));
                item.setItemMeta(meta);
            }
        }
    }
}