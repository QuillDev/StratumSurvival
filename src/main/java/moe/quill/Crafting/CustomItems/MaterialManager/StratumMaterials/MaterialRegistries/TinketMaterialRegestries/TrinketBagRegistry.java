package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.TinketMaterialRegestries;

import moe.quill.Crafting.CustomItems.Attributes.ItemAttributes;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
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


            final var SMALL_TRINKET_BAG = new ItemStack(Material.RABBIT_HIDE);
            final var SMALL_TRINKET_BAG_META = SMALL_TRINKET_BAG.getItemMeta();
            final var SMALL_TRINKET_BAG_DATA = SMALL_TRINKET_BAG_META.getPersistentDataContainer();
            SMALL_TRINKET_BAG_META.displayName(Component.text("Small Trinket Bag"));
            SMALL_TRINKET_BAG_META.setLocalizedName("Small Trinket Bag");
            SMALL_TRINKET_BAG_META.setCustomModelData(1);
            SMALL_TRINKET_BAG_DATA.set(ItemAttributes.inventorySizeKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(3));
            SMALL_TRINKET_BAG_DATA.set(ItemAttributes.inventoryItemDataKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeItemList(emptyItemList));
            SMALL_TRINKET_BAG.setItemMeta(SMALL_TRINKET_BAG_META);

            final var MEDIUM_TRINKET_BAG = new ItemStack(Material.RABBIT_HIDE);
            final var MEDIUM_TRINKET_BAG_META = MEDIUM_TRINKET_BAG.getItemMeta();
            final var MEDIUM_TRINKET_BAG_DATA = MEDIUM_TRINKET_BAG_META.getPersistentDataContainer();
            MEDIUM_TRINKET_BAG_META.displayName(Component.text("Medium Trinket Bag"));
            MEDIUM_TRINKET_BAG_META.setLocalizedName("Medium Trinket Bag");
            MEDIUM_TRINKET_BAG_META.setCustomModelData(1);
            MEDIUM_TRINKET_BAG_DATA.set(ItemAttributes.inventorySizeKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(6));
            MEDIUM_TRINKET_BAG_DATA.set(ItemAttributes.inventoryItemDataKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeItemList(emptyItemList));
            MEDIUM_TRINKET_BAG.setItemMeta(MEDIUM_TRINKET_BAG_META);

            final var LARGE_TRINKET_BAG = new ItemStack(Material.RABBIT_HIDE);
            final var LARGE_TRINKET_BAG_META = LARGE_TRINKET_BAG.getItemMeta();
            final var LARGE_TRINKET_BAG_DATA = LARGE_TRINKET_BAG_META.getPersistentDataContainer();
            LARGE_TRINKET_BAG_META.displayName(Component.text("Large Trinket Bag"));
            LARGE_TRINKET_BAG_META.setLocalizedName("Large Trinket Bag");
            LARGE_TRINKET_BAG_META.setCustomModelData(1);
            LARGE_TRINKET_BAG_DATA.set(ItemAttributes.inventorySizeKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(9));
            LARGE_TRINKET_BAG_DATA.set(ItemAttributes.inventoryItemDataKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeItemList(emptyItemList));
            LARGE_TRINKET_BAG.setItemMeta(LARGE_TRINKET_BAG_META);

            //TODO: ADD KEYS
            put(StratumMaterial.SMALL_TRINKET_BAG.name(), SMALL_TRINKET_BAG);
            put(StratumMaterial.MEDIUM_TRINKET_BAG.name(), MEDIUM_TRINKET_BAG);
            put(StratumMaterial.LARGE_TRINKET_BAG.name(), LARGE_TRINKET_BAG);
        }};
    }
}
