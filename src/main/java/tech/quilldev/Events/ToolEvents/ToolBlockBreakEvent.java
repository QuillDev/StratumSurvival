package tech.quilldev.Events.ToolEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import tech.quilldev.CustomItemsV1.ItemAttributes.ToolAttributes.ToolAttribute;

import java.util.ArrayList;

public class ToolBlockBreakEvent implements Listener {

    private final ArrayList<ToolAttribute> attributes;

    public ToolBlockBreakEvent(ArrayList<ToolAttribute> attributes) {
        this.attributes = attributes;
    }

    @EventHandler
    public void toolBlockBreakEvent(BlockBreakEvent event) {
        final var player = event.getPlayer();
        final var holding = player.getInventory().getItemInMainHand();
        if (!holding.hasItemMeta()) return; //if the item has no meta, ignore it

        //Get the data container on the item
        final var data = holding.getItemMeta().getPersistentDataContainer();
        if (data.getKeys().size() <= 0) return; //If we don't have any special data keys, ignore this item use

        //Run any executable components that are on the item
        data.getKeys().forEach(namespacedKey -> {
            final var match = attributes
                    .stream()
                    .filter(attr -> attr.key.getKey().equals(namespacedKey.getKey()))
                    .findFirst();
            if (match.isEmpty()) return;
            match.get().execute(event); //Execute matches
        });
    }
}