package tech.quilldev.Events.AttributeEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.ItemAttributes.OnHitAttributes.OnHitAttribute;

import java.util.ArrayList;

public class HandleOnHitAttributeEvent implements Listener {

    public final ArrayList<OnHitAttribute> attributes;

    public HandleOnHitAttributeEvent(ArrayList<OnHitAttribute> attributes) {
        this.attributes = attributes;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return; //make sure the person who did damage was the player

        final var player = ((Player) event.getDamager()).getPlayer(); //get the player

        //Make sure the player exists then manage their attributes
        if (player == null) return;
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
            if (!match.isPresent()) return;

            //Get the keys double value
            final var modifier = data.get(match.get().key, PersistentDataType.FLOAT);
            if (modifier == null) return;
            match.get().execute(event, modifier); //Execute matches
        });
    }
}
