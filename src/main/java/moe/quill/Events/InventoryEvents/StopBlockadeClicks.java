package moe.quill.Events.InventoryEvents;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class StopBlockadeClicks implements Listener {

    private final ItemStack blockade;

    public StopBlockadeClicks(MaterialManager materialManager) {
        this.blockade = materialManager.getItem(StratumMaterial.BLOCKADE);
    }

    @EventHandler
    public void stopBlockadeClicks(InventoryClickEvent event) {
        if (event.getInventory().getType().equals(InventoryType.PLAYER)) return;
        final var touched = event.getCurrentItem();
        if (touched == null) return;
        if (!touched.equals(blockade)) return;
        event.setCancelled(true);
    }
}
