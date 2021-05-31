package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.TinketMaterialRegestries;

import moe.quill.stratumsurvival.Crafting.GlobalKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.stratumsurvival.StratumSurvival;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.HashMap;

public class TrinketBagRegistry extends MaterialRegistry {

    private final NamespacedKey inventorySizeKey;
    private final NamespacedKey itemDataKey;

    public TrinketBagRegistry(IKeyManager keyManager) {
        super(keyManager, MaterialKey.TRINKET_BAG_KEY);
        this.inventorySizeKey = keyManager.getKey(GlobalKey.INVENTORY_SIZE_KEY);
        this.itemDataKey = keyManager.getKey(GlobalKey.ITEM_DATA_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final var emptyItemList = new ArrayList<ItemStack>();


            final var TRINKET_BAG_SMALL = new ItemStack(Material.RABBIT_HIDE);
            final var TRINKET_BAG_SMALL_META = TRINKET_BAG_SMALL.getItemMeta();
            final var TRINKET_BAG_SMALL_DATA = TRINKET_BAG_SMALL_META.getPersistentDataContainer();
            TRINKET_BAG_SMALL_META.displayName(Component.text("Small Trinket Bag"));
            TRINKET_BAG_SMALL_META.setLocalizedName("Small Trinket Bag");
            TRINKET_BAG_SMALL_META.setCustomModelData(1);
            TRINKET_BAG_SMALL_DATA.set(inventorySizeKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeFloat(3));
            TRINKET_BAG_SMALL_DATA.set(itemDataKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeItemList(emptyItemList));
            TRINKET_BAG_SMALL.setItemMeta(TRINKET_BAG_SMALL_META);

            final var TRINKET_BAG_MEDIUM = new ItemStack(Material.RABBIT_HIDE);
            final var TRINKET_BAG_MEDIUM_META = TRINKET_BAG_MEDIUM.getItemMeta();
            final var TRINKET_BAG_MEDIUM_DATA = TRINKET_BAG_MEDIUM_META.getPersistentDataContainer();
            TRINKET_BAG_MEDIUM_META.displayName(Component.text("Medium Trinket Bag"));
            TRINKET_BAG_MEDIUM_META.setLocalizedName("Medium Trinket Bag");
            TRINKET_BAG_MEDIUM_META.setCustomModelData(2);
            TRINKET_BAG_MEDIUM_DATA.set(inventorySizeKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeFloat(5));
            TRINKET_BAG_MEDIUM_DATA.set(itemDataKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeItemList(emptyItemList));
            TRINKET_BAG_MEDIUM.setItemMeta(TRINKET_BAG_MEDIUM_META);

            final var TRINKET_BAG_LARGE = new ItemStack(Material.RABBIT_HIDE);
            final var TRINKET_BAG_LARGE_META = TRINKET_BAG_LARGE.getItemMeta();
            final var TRINKET_BAG_LARGE_DATA = TRINKET_BAG_LARGE_META.getPersistentDataContainer();
            TRINKET_BAG_LARGE_META.displayName(Component.text("Large Trinket Bag"));
            TRINKET_BAG_LARGE_META.setLocalizedName("Large Trinket Bag");
            TRINKET_BAG_LARGE_META.setCustomModelData(3);
            TRINKET_BAG_LARGE_DATA.set(inventorySizeKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeFloat(7));
            TRINKET_BAG_LARGE_DATA.set(itemDataKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeItemList(emptyItemList));
            TRINKET_BAG_LARGE.setItemMeta(TRINKET_BAG_LARGE_META);

            final var TRINKET_BAG_HUGE = new ItemStack(Material.RABBIT_HIDE);
            final var TRINKET_BAG_HUGE_META = TRINKET_BAG_HUGE.getItemMeta();
            final var TRINKET_BAG_HUGE_DATA = TRINKET_BAG_HUGE_META.getPersistentDataContainer();
            TRINKET_BAG_HUGE_META.displayName(Component.text("Huge Trinket Bag"));
            TRINKET_BAG_HUGE_META.setLocalizedName("Huge Trinket Bag");
            TRINKET_BAG_HUGE_META.setCustomModelData(4);
            TRINKET_BAG_HUGE_DATA.set(inventorySizeKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeFloat(9));
            TRINKET_BAG_HUGE_DATA.set(itemDataKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeItemList(emptyItemList));
            TRINKET_BAG_HUGE.setItemMeta(TRINKET_BAG_HUGE_META);

            put(StratumMaterial.TRINKET_BAG_SMALL.name(), TRINKET_BAG_SMALL);
            put(StratumMaterial.TRINKET_BAG_MEDIUM.name(), TRINKET_BAG_MEDIUM);
            put(StratumMaterial.TRINKET_BAG_LARGE.name(), TRINKET_BAG_LARGE);
            put(StratumMaterial.TRINKET_BAG_HUGE.name(), TRINKET_BAG_HUGE);
        }};
    }
}
