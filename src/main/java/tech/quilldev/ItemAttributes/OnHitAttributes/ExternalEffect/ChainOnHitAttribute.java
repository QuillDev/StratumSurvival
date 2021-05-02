package tech.quilldev.ItemAttributes.OnHitAttributes.ExternalEffect;

import com.destroystokyo.paper.ParticleBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.ItemAttributes.OnHitAttributes.OnHitAttribute;

import java.util.ArrayList;
import java.util.Collections;

public class ChainOnHitAttribute extends OnHitAttribute {
    public ChainOnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    private final int maxBounces = 20;


    @Override
    public void execute(EntityDamageByEntityEvent event, float modifier) {
        if (!(event.getDamager() instanceof Player)) return;
        if (modifier < rand.nextFloat()) return;

        //Get the player and the target entity
        final var player = ((Player) event.getDamager()).getPlayer();
        if (player == null) return;

        //Keep track of previous targets
        final var previousTargets = new ArrayList<Entity>(Collections.singletonList(player));
        var entity = event.getEntity(); //Get the first entity we struck

        final var damage = Math.max(event.getDamage() * .25, 2);
        var bounces = 0;
        for (; bounces < maxBounces; bounces++) {
            final var target = getCloseEnemies(entity, previousTargets);
            if (target == null) break;

            final var particle = Particle.FIREWORKS_SPARK;
            createParticles(entity.getLocation(), target.getLocation(), particle, player.getWorld());
            target.damage(damage);
            previousTargets.add(target);
            entity = target;
        }

        final var theWorldIsEndingLocation = previousTargets.get(previousTargets.size() - 1).getLocation();
        player.getWorld().strikeLightning(theWorldIsEndingLocation);
    }

    private void createParticles(Location start, Location end, Particle particle, World world) {
        final var mid = end.toVector().midpoint(start.toVector()).toLocation(world);
        final var topMid = mid.toVector().midpoint(end.toVector()).toLocation(world);
        final var bottomMid = mid.toVector().midpoint(start.toVector()).toLocation(world);
        final var closestTopMid = topMid.toVector().midpoint(end.toVector());
        final var closestBottompMid = bottomMid.toVector().midpoint(start.toVector());

        new ParticleBuilder(Particle.REDSTONE)
                .color(Color.fromRGB(177, 156, 217))
                .count(7)
                .extra(0)
                .location(new Location(world, start.getX(), start.getY() + 1, start.getZ()))
                .spawn()
                .location(new Location(world, end.getX(), end.getY() + 1, end.getZ()))
                .spawn()
                .location(new Location(world, mid.getX(), mid.getY() + 1, mid.getZ()))
                .spawn()
                .location(new Location(world, topMid.getX(), topMid.getY() + 1, topMid.getZ()))
                .spawn()
                .location(new Location(world, bottomMid.getX(), bottomMid.getY() + 1, bottomMid.getZ()))
                .spawn()
                .location(new Location(world, closestBottompMid.getX(), closestBottompMid.getY() + 1, closestTopMid.getZ()))
                .spawn()
                .location(new Location(world, closestTopMid.getX(), closestTopMid.getY() + 1, closestTopMid.getZ()))
                .spawn();
    }

    private Damageable getCloseEnemies(Entity entity, ArrayList<Entity> previousTargets) {
        var targets = entity.getNearbyEntities(8, 8, 8)
                .stream()
                .filter(e -> e instanceof Damageable)
                .filter(e -> !previousTargets.contains(e))
                .map(e -> (Damageable) e)
                .findFirst()
                .orElse(null);
        return targets;
    }
}
