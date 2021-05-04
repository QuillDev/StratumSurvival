package tech.quilldev.Events.ItemCreationEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import tech.quilldev.CustomItemsV1.ItemGenerator;

public class GenerateItemOnMobDeath implements Listener {

    private final ItemGenerator itemGenerator;

    public GenerateItemOnMobDeath(ItemGenerator itemGenerator) {
        this.itemGenerator = itemGenerator;
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent event) {
        final var entity = event.getEntity();
        final var player = entity.getKiller();
        if (player == null) return;

        final var item = itemGenerator.generateRandomWeapon(.05f, .38f);
        if (item == null) return;
        player.getWorld().dropItemNaturally(entity.getLocation(), item);
    }
}
