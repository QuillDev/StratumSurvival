package moe.quill.stratumsurvival.Events.ToolEvents.TrinketBag;

import moe.quill.stratumsurvival.Crafting.GlobalKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.stratumsurvival.StratumSurvival;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class TrinketBagHelper {

    private final ItemStack blockade;
    private final static int maxBagSize = 9;

    //Item Keys
    private final NamespacedKey trinketBagKey;
    private final NamespacedKey inventorySizeKey;
    private final NamespacedKey itemDataKey;

    public TrinketBagHelper(IKeyManager keyManager, MaterialManager materialManager) {
        this.trinketBagKey = keyManager.getKey(MaterialKey.TRINKET_BAG_KEY);
        this.inventorySizeKey = keyManager.getKey(GlobalKey.INVENTORY_SIZE_KEY);
        this.itemDataKey = keyManager.getKey(GlobalKey.ITEM_DATA_KEY);
        this.blockade = materialManager.getItem(StratumMaterial.BLOCKADE);
    }

    /**
     * Check if what the player is holding is a trinket bag
     *
     * @param view to check
     * @return whether the held item is a trinket bag or not
     */
    public boolean isTrinketView(InventoryView view) {
        final var title = view.title();
        if (!(title instanceof TextComponent)) return false;
        final var viewText = ((TextComponent) view.title()).content();
        return viewText.contains("Trinket Bag");
    }

    /**
     * Save the inventory of the current player
     *
     * @param player    to save the inventory of
     * @param inventory to save
     * @param view      to get items from
     */
    public void saveCurrentInventory(HumanEntity player, Inventory inventory, InventoryView view) {
        if (!isTrinketView(view)) return;
        final var trinketBagData = getTrinketBagData(player.getInventory().getItemInMainHand());
        if (trinketBagData == null) return;

        //Get items to write
        final var itemsToWrite = new ArrayList<ItemStack>();
        for (int idx = 0; idx < trinketBagData.getInventorySize(); idx++) {
            var itemToAdd = inventory.getItem(idx);
            if (itemToAdd == null) continue;
            itemsToWrite.add(itemToAdd);
        }

        //Write the new items to the trinket bag
        writeItemData(trinketBagData, itemsToWrite);
    }

    /**
     * Render the trinket bag for the given player
     *
     * @param player to render the trinket bag for
     */
    public void render(Player player) {
        //Get the item in the players hand and the data around it
        final var trinketBagData = getTrinketBagData(player.getInventory().getItemInMainHand());
        if (trinketBagData == null) return;

        //Create the inventory from the bags data
        final var bagInventory = Bukkit.createInventory(player, maxBagSize, Component.text(trinketBagData.getLocalizedName()));
        trinketBagData.getItems().forEach(bagInventory::addItem);
        for (int idx = maxBagSize - 1; idx > trinketBagData.getInventorySize() - 1; idx--) {
            bagInventory.setItem(idx, blockade);
        }
        player.openInventory(bagInventory);
    }

    /**
     * Get the trinket bag data for the current item
     *
     * @param item to check whether it's a trinket bag or not
     * @return the data for that trinket bag
     */
    public TrinketBagData getTrinketBagData(ItemStack item) {
        final var heldItemMeta = item.getItemMeta();
        if (heldItemMeta == null) return null;
        final var heldItemData = heldItemMeta.getPersistentDataContainer();

        //Check if the item has the appropriate keys
        if (!heldItemData.has(trinketBagKey, PersistentDataType.BYTE_ARRAY)) return null;
        if (!heldItemData.has(inventorySizeKey, PersistentDataType.BYTE_ARRAY)) return null;
        if (!heldItemData.has(itemDataKey, PersistentDataType.BYTE_ARRAY)) return null;

        //Get the data bytes from the inventory keys
        final var inventorySizeBytes = heldItemData.get(inventorySizeKey, PersistentDataType.BYTE_ARRAY);
        final var inventoryDataBytes = heldItemData.get(itemDataKey, PersistentDataType.BYTE_ARRAY);
        //Get the values from the bytes
        final var inventorySize = (int) StratumSurvival.serializer.deserializeFloat(inventorySizeBytes);
        final var inventoryData = StratumSurvival.serializer.deserializeItemList(inventoryDataBytes);

        //If the data is bad, return null
        if (inventoryData == null) return null;
        if (Double.isNaN(inventorySize)) return null;
        return new TrinketBagData(item, inventoryData, inventorySize);
    }

    /**
     * Write the items to the given trinket bag
     *
     * @param trinketBagData to use for writing data
     * @param items          to write to the trinket bag
     */
    public void writeItemData(TrinketBagData trinketBagData, ArrayList<ItemStack> items) {
        final var trinketBag = trinketBagData.getTrinketBag();
        final var trinketBagMeta = trinketBag.getItemMeta();
        if (trinketBagMeta == null) return;
        final var trinketBagDataContainer = trinketBagMeta.getPersistentDataContainer();
        trinketBagDataContainer.set(itemDataKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeItemList(items));
        trinketBag.setItemMeta(trinketBagMeta);
    }

    /**
     * Get whether the given item is a trinket bag or not
     *
     * @param itemStack to check whether it's a trinket bag
     * @return whether it's a trinket bag
     */
    public boolean isTrinketBag(ItemStack itemStack) {
        try {
            final var meta = itemStack.getItemMeta();
            final var data = meta.getPersistentDataContainer();
            return data.has(trinketBagKey, PersistentDataType.BYTE_ARRAY);
        } catch (Exception ignored) {
            return false;
        }
    }

}
