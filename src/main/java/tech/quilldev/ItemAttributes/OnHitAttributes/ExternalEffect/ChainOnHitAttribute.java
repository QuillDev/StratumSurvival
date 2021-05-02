package tech.quilldev.ItemAttributes.OnHitAttributes.ExternalEffect;

import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.ItemAttributes.OnHitAttributes.OnHitAttribute;
import tech.quilldev.Particles.ParticleFactory;

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
            createParticles(entity.getLocation(), target.getLocation(), player.getWorld());
            target.damage(damage);
            previousTargets.add(target);
            entity = target;
        }

        final var theWorldIsEndingLocation = previousTargets.get(previousTargets.size() - 1).getLocation();
        player.getWorld().strikeLightning(theWorldIsEndingLocation);
    }

    private void createParticles(Location start, Location end, World world) {
        final var factory = new ParticleFactory();
        factory.constructParticleGeometry(
                factory.createParticleLine(start, end, 5, 1),
                Color.fromRGB(255, 255, 0),
                world);
    }

    private Damageable getCloseEnemies(Entity entity, ArrayList<Entity> previousTargets) {
        var targets = entity.getNearbyEntities(6, 6, 6)
                .stream()
                .filter(e -> e instanceof Damageable)
                .filter(e -> !previousTargets.contains(e))
                .map(e -> (Damageable) e)
                .findFirst()
                .orElse(null);
        return targets;
    }
}
