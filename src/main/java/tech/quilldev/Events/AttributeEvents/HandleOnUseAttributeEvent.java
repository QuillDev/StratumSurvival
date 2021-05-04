package tech.quilldev.Events.AttributeEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnUseAttributes.OnUseAttribute;

import java.util.ArrayList;

public class HandleOnUseAttributeEvent implements Listener {

    private final ArrayList<OnUseAttribute> attributes;

    public HandleOnUseAttributeEvent(ArrayList<OnUseAttribute> onUseAttributes) {
        this.attributes = onUseAttributes;
    }

    @EventHandler
    public void onPlayerUseItem(PlayerInteractEvent event) {
        //Make sure it only triggers on right clicks
        final var action = event.getAction();
        if (!(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))) return;

        //Get the player and what they're holding
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
            match.get().execute(player); //Execute matches
        });
    }
}
