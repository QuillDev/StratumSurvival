package moe.quill.Crafting.CustomCraftingEvents;

import moe.quill.Crafting.CustomItems.Attributes.ItemAttributes;
import moe.quill.Utils.Serialization.StratumSerialization;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class GrindCustomWeaponEvent implements Listener {

    private final StratumMaterialManager materialManager;

    public GrindCustomWeaponEvent(StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    @EventHandler
    public void grindCustomItemEvent(PlayerInteractEvent event) {
        if (!(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) return;
        final var clickedBlock = event.getClickedBlock();
        if (clickedBlock == null) return;
        if (!clickedBlock.getType().equals(Material.GRINDSTONE)) return;
        final var heldItem = event.getItem();
        if (heldItem == null) return;
        final var meta = heldItem.getItemMeta();
        if (meta == null) return;

        //Get the level data from the data container
        final var data = meta.getPersistentDataContainer();
        if (data.getKeys().size() == 0) return;
        if (!data.has(ItemAttributes.levelKey, PersistentDataType.BYTE_ARRAY)) return;
        final var levelBytes = data.get(ItemAttributes.levelKey, PersistentDataType.BYTE_ARRAY);
        var level = (int) StratumSerialization.deserializeFloat(levelBytes);
        // Get the corresponding item based on the level
        final var item = materialManager.getCrystalForLevel(level);
        if (item == null) return;
        final var inventory = event.getPlayer().getInventory();
        inventory.remove(heldItem);
        inventory.addItem(item);
        event.setCancelled(true); //cancel the event
    }
}
