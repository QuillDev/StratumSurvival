package moe.quill.Events.ToolEvents.TrinketBag;


import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class TrinketBagData {

    private final ItemStack trinketBag;
    private final ArrayList<ItemStack> items;
    private final int inventorySize;


    public TrinketBagData(ItemStack trinketBag, ArrayList<ItemStack> items, int inventorySize) {
        this.trinketBag = trinketBag;
        this.items = items;
        this.inventorySize = inventorySize;
    }

    /**
     * Get the items in the trinket bag
     *
     * @return the items in the trinket bag
     */
    public ArrayList<ItemStack> getItems() {
        return items;
    }

    /**
     * Get the ItemStack for the trinket bag
     *
     * @return the item stack for the trinket bag
     */
    public ItemStack getTrinketBag() {
        return trinketBag;
    }

    /**
     * Get the inventory size of the trinket bag
     *
     * @return the size of the trinket bag
     */
    public int getInventorySize() {
        return inventorySize;
    }

    /**
     * Get the localized name for the trinket bag
     *
     * @return the trinket bag name
     */
    public String getLocalizedName() {
        final var meta = trinketBag.getItemMeta();
        if (meta == null) return "";
        return meta.getLocalizedName();
    }

}
