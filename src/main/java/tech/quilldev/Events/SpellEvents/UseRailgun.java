package tech.quilldev.Events.SpellEvents;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BoundingBox;
import tech.quilldev.Particles.ParticleFactory;

public class UseRailgun implements Listener {

    private final int range = 50;
    private final static ParticleFactory particleFactory = new ParticleFactory();

    @EventHandler
    public void OnUseRailgun(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (!event.getItem().getType().equals(Material.WOODEN_HOE)) return;

        final var player = event.getPlayer();
        final var eyesLoc = player.getEyeLocation();
//        x1 – the first corner's x value
//        y1 – the first corner's y value
//        z1 – the first corner's z value
//        x2 – the second corner's x value
//        y2 – the second corner's y value
//        z2 – the second corner's z value
        final var eyes = eyesLoc.add(eyesLoc.getDirection());
        final var hitbox = new BoundingBox(
                eyes.getX() - .5,
                eyes.getY() + .5,
                eyes.getZ(),
                eyes.getX() + .5,
                eyes.getY() - .5,
                eyes.getZ() + range
        );

        //Draw the hitbox
        particleFactory.constructParticleGeometry(
                particleFactory.createHitboxGeometry(hitbox, player.getWorld()),
                Color.AQUA,
                player.getWorld()
        );
        final var targets = player.getNearbyEntities(range, range, range);
        targets.stream()
                .filter(target -> target instanceof Damageable)
                .map(target -> (((Damageable) target)))
                .filter(target -> target.getBoundingBox().overlaps(hitbox))
                .forEach(entity -> entity.damage(1000));
    }
}
