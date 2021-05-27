package moe.quill.Crafting.Items.EventHandler;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.KeyManager;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import moe.quill.Crafting.Items.Attributes.ItemAttributes;
import moe.quill.Utils.Serialization.StratumSerialization;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HandleAttributeEvents implements Listener {

    private final KeyManager keyManager;

    public HandleAttributeEvents(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof LivingEntity)) return;
        handleItemAttributes((LivingEntity) event.getDamager(), event);
    }

    @EventHandler
    public void onArrowDamageEvent(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Arrow)) return; //if the damager is not an arrow, return
        final var arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Player)) return;
        final var shooter = (Player) arrow.getShooter();
        handleItemAttributes(shooter, event);
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

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        handleItemAttributes(event.getPlayer(), event);
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
        if (data.has(ItemAttributes.obfuscatedKey, PersistentDataType.BYTE_ARRAY)) return;

        // Run the event over all keys on this item and see if any match
        data.getKeys().forEach(key -> {
            if (!hasAttribute(key.getKey())) return;
            final var attr = ItemAttributes.getAttribute(AttributeKey.valueOf(key.getKey().toUpperCase()));
            if (attr == null) return;
            final var nsKey = keyManager.getNsKey(attr.key);
            final var modBytes = data.get(nsKey, PersistentDataType.BYTE_ARRAY);
            final var modifier = StratumSerialization.deserializeFloat(modBytes);
            attr.execute(event, modifier);
        });
    }

    //Check if the enum list has the given attribute
    public boolean hasAttribute(String query) {
        for (final var attr : AttributeKey.values()) {
            if (attr.name().equalsIgnoreCase(query)) {
                return true;
            }
        }
        return false;
    }
}
