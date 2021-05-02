package tech.quilldev.ItemAttributes.OnHitAttributes.ExternalEffect;

import com.destroystokyo.paper.ParticleBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import tech.quilldev.ItemAttributes.OnHitAttributes.OnHitAttribute;

import java.util.ArrayList;
import java.util.Collections;

public class ChainOnHitAttribute extends OnHitAttribute {
    public ChainOnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    private final int maxBounces = 5;


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
        for (var i = 0; i < maxBounces; i++) {
            final var target = getCloseEnemies(entity, previousTargets);
            if (target == null) break;

            final var lastVector = entity.getLocation().toVector();
            final var currentVector = target.getLocation().toVector();
            final var midPoint = lastVector.midpoint(currentVector).toLocation(player.getWorld());

            final var particle = Particle.FIREWORKS_SPARK;
            createParticles(entity.getLocation(), target.getLocation(), particle, player.getWorld());
            target.damage(damage);
            previousTargets.add(target);
            entity = target;

        }
    }

    private void createParticles(Location start, Location end, Particle particle, World world) {
        final var mid = end.toVector().midpoint(start.toVector()).toLocation(world);
        var builder = new ParticleBuilder(Particle.REDSTONE)
                .color(Color.fromRGB(177, 156, 217))
                .count(3)
                .extra(0)
                .location(new Location(world, start.getX(), start.getY() + 1, start.getZ()))
                .spawn()
                .location(new Location(world, end.getX(), end.getY() + 1, end.getZ()))
                .spawn()
                .location(new Location(world, mid.getX(), mid.getY() + 1, mid.getZ()))
                .spawn();
    }

    private Damageable getCloseEnemies(Entity entity, ArrayList<Entity> previousTargets) {
        var targets = entity.getNearbyEntities(5, 5, 5)
                .stream()
                .filter(e -> e instanceof Damageable)
                .filter(e -> !previousTargets.contains(e))
                .map(e -> (Damageable) e)
                .findFirst()
                .orElse(null);
        System.out.println(targets);
        return targets;
    }

//    @Override
//    public void execute(EntityDamageByEntityEvent event, float modifier) {
//        if (!(event.getDamager() instanceof Player)) return;
//        if (modifier < rand.nextFloat()) return;
//
//        //Get the player and the target entity
//        final var player = ((Player) event.getDamager()).getPlayer();
//        if (player == null) return;
//        final var entity = event.getEntity();
//
//        //Get valid targets
//        final var targets = entity
//                .getNearbyEntities(5, 5, 5)
//                .stream()
//                .filter(target -> (target instanceof Damageable))
//                .map(target -> (Damageable) target)
//                .collect(Collectors.toList());
//
//        if (targets.size() <= 0) return; //make sure there are targets to chain
//        final var damage = Math.round(Math.max(event.getDamage() * .25f, 2));
//        targets.forEach((target) -> target.damage(damage));
//
//        player.sendMessage(
//                Component.text("You chained")
//                        .append(Component.space())
//                        .append(Component.text(targets.size()))
//                        .append(Component.space())
//                        .append(Component.text("for"))
//                        .append(Component.space())
//                        .append(Component.text(damage))
//                        .append(Component.space())
//                        .append(Component.text("!"))
//        );
//    }
}
