package moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.TinketMaterialRegestries;

import moe.quill.Crafting.Items.Attributes.ItemAttributes;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Utils.Serialization.StratumSerialization;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.HashMap;

public class TrinketBagRegistry extends MaterialRegistry {
    public TrinketBagRegistry() {
        super(MaterialKey.TRINKET_BAG_KEY);
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
            TRINKET_BAG_SMALL_DATA.set(ItemAttributes.inventorySizeKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(3));
            TRINKET_BAG_SMALL_DATA.set(ItemAttributes.inventoryItemDataKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeItemList(emptyItemList));
            TRINKET_BAG_SMALL.setItemMeta(TRINKET_BAG_SMALL_META);

            final var TRINKET_BAG_MEDIUM = new ItemStack(Material.RABBIT_HIDE);
            final var TRINKET_BAG_MEDIUM_META = TRINKET_BAG_MEDIUM.getItemMeta();
            final var TRINKET_BAG_MEDIUM_DATA = TRINKET_BAG_MEDIUM_META.getPersistentDataContainer();
            TRINKET_BAG_MEDIUM_META.displayName(Component.text("Medium Trinket Bag"));
            TRINKET_BAG_MEDIUM_META.setLocalizedName("Medium Trinket Bag");
            TRINKET_BAG_MEDIUM_META.setCustomModelData(2);
            TRINKET_BAG_MEDIUM_DATA.set(ItemAttributes.inventorySizeKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(6));
            TRINKET_BAG_MEDIUM_DATA.set(ItemAttributes.inventoryItemDataKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeItemList(emptyItemList));
            TRINKET_BAG_MEDIUM.setItemMeta(TRINKET_BAG_MEDIUM_META);

            final var TRINKET_BAG_LARGE = new ItemStack(Material.RABBIT_HIDE);
            final var TRINKET_BAG_LARGE_META = TRINKET_BAG_LARGE.getItemMeta();
            final var TRINKET_BAG_LARGE_DATA = TRINKET_BAG_LARGE_META.getPersistentDataContainer();
            TRINKET_BAG_LARGE_META.displayName(Component.text("Large Trinket Bag"));
            TRINKET_BAG_LARGE_META.setLocalizedName("Large Trinket Bag");
            TRINKET_BAG_LARGE_META.setCustomModelData(3);
            TRINKET_BAG_LARGE_DATA.set(ItemAttributes.inventorySizeKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(9));
            TRINKET_BAG_LARGE_DATA.set(ItemAttributes.inventoryItemDataKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeItemList(emptyItemList));
            TRINKET_BAG_LARGE.setItemMeta(TRINKET_BAG_LARGE_META);

            //TODO: ADD KEYS
            put(StratumMaterial.TRINKET_BAG_SMALL.name(), TRINKET_BAG_SMALL);
            put(StratumMaterial.TRINKET_BAG_MEDIUM.name(), TRINKET_BAG_MEDIUM);
            put(StratumMaterial.TRINKET_BAG_LARGE.name(), TRINKET_BAG_LARGE);
        }};
    }
}
