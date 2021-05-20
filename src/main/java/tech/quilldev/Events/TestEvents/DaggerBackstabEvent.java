package tech.quilldev.Events.TestEvents;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.MaterialKey;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

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
        final var meta = item.getItemMeta();
        if (meta == null) return;

        //Get the dagger key and the data container for the held item
        final var daggerKey = materialManager.getNamespacedMaterialKey(MaterialKey.DAGGER_KEY);
        final var data = meta.getPersistentDataContainer();
        //If the item is not a dagger, return
        if (!data.has(daggerKey, PersistentDataType.BYTE_ARRAY)) {
            return;
        }

        final var playerRotation = player.getLocation().getYaw(); //get the rotation of the player
        final var targetRotation = target.getLocation().getYaw(); //get the rotation of the
        final var deltaRotation = Math.abs(playerRotation - targetRotation);
        if (!(deltaRotation < range || deltaRotation > (360 - range))) return;
        event.setDamage(event.getDamage() * 1.5);
        player.sendMessage(Component.text("You backstabbed your opponent!").color(TextColor.color(0xFF544D)));

    }
}
