package tech.quilldev.CustomItemsv2.Effects;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;
import tech.quilldev.Particles.ParticleFactory;

import java.util.ArrayList;
import java.util.Collections;

public class ChainDamageEffect extends Effect {

    public void execute(EntityDamageByEntityEvent event, float modifier, int maxBounces) {
        if (!(event.getDamager() instanceof Player)) return;
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
                factory.createParticleLine(start, end, 5, new Vector(0, 1, 0)),
                Color.fromRGB(255, 255, 0),
                world);
    }

    private Damageable getCloseEnemies(Entity entity, ArrayList<Entity> previousTargets) {
        return entity.getNearbyEntities(6, 6, 6)
                .stream()
                .filter(e -> e instanceof Damageable)
                .filter(e -> !previousTargets.contains(e))
                .map(e -> (Damageable) e)
                .findFirst()
                .orElse(null);
    }
}
