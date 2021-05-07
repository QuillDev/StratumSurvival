package tech.quilldev.Crafting.CustomCraftingEvents;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.Serialization.StratumSerialization;

public class GrindCustomWeaponEvent implements Listener {

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
        final var item = switch (level) {
            case 1 -> StratumMaterial.SHARD_COMMON;
            case 2 -> StratumMaterial.SHARD_UNCOMMON;
            case 3 -> StratumMaterial.SHARD_RARE;
            case 4 -> StratumMaterial.SHARD_EPIC;
            case 5, 6 -> StratumMaterial.SHARD_LEGENDARY;
            default -> null;
        };
        if (item == null) return;
        final var inventory = event.getPlayer().getInventory();
        inventory.remove(heldItem);
        inventory.addItem(item);
        event.setCancelled(true); //cancel the event
    }
}
