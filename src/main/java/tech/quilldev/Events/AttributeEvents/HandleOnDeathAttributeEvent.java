package tech.quilldev.Events.AttributeEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnDeathAttributes.OnDeathAttribute;

import java.util.ArrayList;

public class HandleOnDeathAttributeEvent implements Listener {

    private final ArrayList<OnDeathAttribute> attributes;

    public HandleOnDeathAttributeEvent(ArrayList<OnDeathAttribute> attributes) {
        this.attributes = attributes;
    }

    @EventHandler
    public void handleEntityDeath(EntityDeathEvent event) {
        final var player = event.getEntity().getKiller();
        if (player == null) return; //Only handle events where the player killed the entity

        final var item = player.getInventory().getItemInMainHand();
        if (!item.hasItemMeta()) return; //if the item doesn't have item meta, we don't care
        final var meta = item.getItemMeta();
        final var data = meta.getPersistentDataContainer();

        //If the item doesn't have any keys, just return out
        if (data.getKeys().size() <= 0) return;

        //TODO: Abstract this to some other class
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
