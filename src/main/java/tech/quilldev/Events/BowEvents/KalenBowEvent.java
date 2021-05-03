package tech.quilldev.Events.BowEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;

public class KalenBowEvent implements Listener {

    @EventHandler
    public void onBowShoot(EntityShootBowEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        final var arrow = event.getProjectile();
        arrow.setVelocity(arrow.getVelocity().multiply(1000));
        arrow.setGlowing(true);
    }
}
