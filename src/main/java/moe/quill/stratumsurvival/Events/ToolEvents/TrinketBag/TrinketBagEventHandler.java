package moe.quill.stratumsurvival.Events.ToolEvents.TrinketBag;

import com.google.inject.Inject;
import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TrinketBagEventHandler implements Listener {
    private final TrinketBagHelper trinketBagHelper;

    //TODO: Make this a service maybe?
    @Inject
    public TrinketBagEventHandler(IKeyManager keyManager, MaterialManager materialManager, ISerializer serializer) {
        this.trinketBagHelper = new TrinketBagHelper(keyManager, materialManager, serializer);
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
