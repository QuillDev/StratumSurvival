package moe.quill.stratumsurvival.Crafting.Items.EventHandler;

import moe.quill.stratumsurvival.Crafting.GlobalKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.ItemAttributes;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.stratumsurvival.StratumSurvival;
import moe.quill.stratumsurvival.Utils.KeyUtils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
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


public class HandleAttributeEvents implements Listener {

    private final IKeyManager keyManager;
    private final NamespacedKey obfuscatedKey;

    public HandleAttributeEvents(IKeyManager keyManager) {
        this.keyManager = keyManager;
        this.obfuscatedKey = keyManager.getKey(GlobalKey.OBFUSCATED_KEY);
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
        if (data.has(obfuscatedKey, PersistentDataType.BYTE_ARRAY)) return;

        // Run the event over all keys on this item and see if any match
        data.getKeys().forEach(key -> {
            final var attr = ItemAttributes.getAttribute(KeyUtils.getAttributeKey(AttributeKey.class, key));
            if (attr == null) return;
            final var nsKey = keyManager.getKey(attr.key);
            final var modBytes = data.get(nsKey, PersistentDataType.BYTE_ARRAY);
            final var modifier = StratumSurvival.serializer.deserializeFloat(modBytes);
            attr.execute(event, modifier);
        });
    }

}
