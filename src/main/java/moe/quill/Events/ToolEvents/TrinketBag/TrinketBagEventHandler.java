package moe.quill.Events.ToolEvents.TrinketBag;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;

public class TrinketBagEventHandler implements Listener {
    private final TrinketBagHelper trinketBagHelper;

    public TrinketBagEventHandler(StratumMaterialManager materialManager) {
        this.trinketBagHelper = new TrinketBagHelper(materialManager);
    }

    //Render the trinket bag when the player right clicks it
    @EventHandler
    public void renderInventoryEvent(PlayerInteractEvent event) {
        trinketBagHelper.render(event.getPlayer());
    }

    //Store inventory data when they close the trinket bag
    @EventHandler
    public void storeInventoryData(InventoryCloseEvent event) {
        trinketBagHelper.saveCurrentInventory(event.getPlayer(), event.getInventory(), event.getView());
    }

    //Make it so you can't move trinket bags while in a trinket bag
    @EventHandler
    public void dontMoveTrinketBags(InventoryClickEvent event) {
        if (!trinketBagHelper.isTrinketView(event.getView())) return;
        if (!trinketBagHelper.isTrinketBag(event.getCurrentItem())) return;
        event.setCancelled(true);
    }
}
