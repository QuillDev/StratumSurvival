package moe.quill.Events.SpellEvents;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import moe.quill.Utils.Particles.ParticleFactory;

import java.util.ArrayList;
import java.util.Arrays;

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
        final var playerLoc = player.getEyeLocation();
        final var hitbox = new BoundingBox(
                playerLoc.getX() - .5,
                playerLoc.getY() + .5,
                playerLoc.getZ(),
                playerLoc.getX() + .5,
                playerLoc.getY() - .5,
                playerLoc.getZ() + range
        );

        rotate(hitbox, playerLoc.getYaw());
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


    //TODO: Make this work (Rotate 3d object around a point in 3d space)
    private void rotate(BoundingBox box, float yaw) {
        final var boxX1 = box.getMinX();
        final var boxY1 = box.getMinY();
        final var boxZ1 = box.getMinZ();
        final var boxX2 = box.getMaxX();
        final var boxY2 = box.getMaxY();
        final var boxZ2 = box.getMaxZ();

        final var points = new ArrayList<>(Arrays.asList(
                new Vector(boxX1, boxY1, boxZ1),
                new Vector(boxX2, boxY1, boxZ1),
                new Vector(boxX1, boxY2, boxZ1),
                new Vector(boxX2, boxY2, boxZ1),
                new Vector(boxX1, boxY1, boxZ2),
                new Vector(boxX2, boxY1, boxZ2),
                new Vector(boxX1, boxY2, boxZ2),
                new Vector(boxX2, boxY2, boxZ2)
        ));

        points.forEach(point -> {
            point.setX(point.getX() * Math.cos(yaw) + point.getZ() * Math.sin(yaw));
            point.setZ(-point.getX() * Math.sin(yaw) + point.getZ() * Math.cos(yaw));
        });

        Double x1 = null;
        Double x2 = null;
        Double y1 = null;
        Double y2 = null;
        Double z1 = null;
        Double z2 = null;

        for (int i = 0; i < points.size(); i++) {
            final var curPoint = points.get(i);

            //Set values on loop 1
            if (i == 0) {
                x1 = curPoint.getX();
                x2 = curPoint.getX();
                y1 = curPoint.getY();
                y2 = curPoint.getY();
                z1 = curPoint.getZ();
                z2 = curPoint.getZ();
                continue;
            }

            x1 = Math.min(x1, curPoint.getX());
            x2 = Math.max(x2, curPoint.getX());
            y1 = Math.min(y1, curPoint.getY());
            y2 = Math.max(y2, curPoint.getY());
            z1 = Math.min(z1, curPoint.getZ());
            z2 = Math.max(z2, curPoint.getZ());
        }

        if (x1 == null) return;
        box.resize(x1, y1, z1, x2, y2, z2);
    }

}
