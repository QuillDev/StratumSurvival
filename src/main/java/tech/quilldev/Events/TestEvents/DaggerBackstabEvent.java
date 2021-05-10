package tech.quilldev.Events.TestEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.Crafting.StratumMaterialManager;

public class DaggerBackstabEvent implements Listener {

    final static float range = 45;

    private final StratumMaterialManager materialManager;

    public DaggerBackstabEvent(StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void handleDaggerBackstab(EntityDamageByEntityEvent event) {
        final var damager = event.getDamager();
        final var target = event.getEntity();
        if (!(damager instanceof Player)) return;
        final var player = ((Player) damager).getPlayer();
        if (player == null) return;
        final var item = player.getInventory().getItemInMainHand();

        //If the item is not a dagger, return
        if (!item.getItemMeta().getPersistentDataContainer().has(materialManager.daggerKey, PersistentDataType.BYTE_ARRAY)) {
            return;
        }

        final var playerRotation = player.getLocation().getYaw();
        final var targetRotation = target.getLocation().getYaw();
        final var deltaRotation = Math.abs(playerRotation - targetRotation);
        if (!(deltaRotation < range || deltaRotation > (360 - range))) return;
        event.setDamage(event.getDamage() * 1.5);
    }
}
