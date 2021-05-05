package tech.quilldev.CustomItemsv2.EventHandler;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.Serialization.StratumSerialization;

public class HandleAttributeEvents implements Listener {

    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof LivingEntity)) return;
        handleItemAttributes((LivingEntity) event.getDamager(), event);
    }

    @EventHandler
    public void onUseEvent(PlayerInteractEvent event) {
        final var action = event.getAction();
        if (!(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))) return;
        handleItemAttributes(event.getPlayer(), event);
    }

    @EventHandler
    public void onMobDeathEvent(EntityDeathEvent event) {
        if (event.getEntity().getKiller() == null) return;
        handleItemAttributes(event.getEntity().getKiller(), event);
    }

    private void handleItemAttributes(LivingEntity entity, Event event) {
        final var equipment = entity.getEquipment();
        if (equipment == null) return;
        final var item = equipment.getItemInMainHand();
        if (item.getType().equals(Material.AIR)) return;
        final var meta = item.getItemMeta();
        if (meta == null) return;
        final var data = meta.getPersistentDataContainer();
        if (data.getKeys().size() == 0) return;

        // Run the event over all keys on this item and see if any match
        data.getKeys().forEach(key -> {
            final var attr = ItemAttributes.getAttribute(key.getKey());
            final var modBytes = data.get(attr.key, PersistentDataType.BYTE_ARRAY);
            final var modifier = StratumSerialization.deserializeFloat(modBytes);
            attr.execute(event, modifier);
        });
    }
}
