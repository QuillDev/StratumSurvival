package moe.quill.CustomItems.Effects;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.util.Vector;
import moe.quill.Particles.ParticleFactory;

import java.util.ArrayList;
import java.util.Collections;

public class ChainDamageEffect extends Effect {

    public void execute(Event event, int maxBounces, float damageMulti) {
        //Get all of the data we need for to execute the event
        final var player = helper.getLivingEntity(event);
        final var baseDamage = helper.getEventDamage(event);
        var entity = helper.getTargetLivingEntity(event); //Get the first entity we struck
        if (player == null || baseDamage == null || entity == null) return;

        //Keep track of previous targets & get damage for teh event
        final var damage = Math.max(baseDamage * damageMulti, 2);
        var previousTargets = new ArrayList<Entity>(Collections.singletonList(player));

        //Calculate bounces
        var bounces = 0;
        for (; bounces < maxBounces; bounces++) {
            final var target = getCloseEnemies(entity, previousTargets);
            if (target == null) break;
            createParticles(entity.getLocation(), target.getLocation(), player.getWorld());
            target.damage(damage);
            previousTargets.add(target);
            entity = target;
        }

        //TODO: Sort bounces by distance too
        sortByDistance(player, previousTargets);


        //If the size of the previous targets list is equal to the max bounces, summon lightning at the last target
        if (previousTargets.size() > Math.ceil(maxBounces / 2f)) {
            final var strikeLocation = previousTargets.get(previousTargets.size() - 1).getLocation();
            player.getWorld().strikeLightning(strikeLocation);
        }

    }

    private void sortByDistance(Entity base, ArrayList<Entity> targets) {
        final var pVec = base.getLocation().toVector();
        targets.sort((a, b) -> {
            final var aVec = a.getLocation().toVector();
            final var bVec = b.getLocation().toVector();
            final var aDistance = aVec.distance(pVec);
            final var bDistance = bVec.distance(pVec);

            if (aDistance > bDistance) {
                return 1;
            } else if (aDistance == bDistance) {
                return 0;
            }
            return -1;
        });

    }

    /**
     * Create particles between the start and end point
     *
     * @param start location (a location to draw line at)
     * @param end   location (b location to draw the line at)
     * @param world to do location math in
     */
    private void createParticles(Location start, Location end, World world) {
        final var factory = new ParticleFactory();
        factory.constructParticleGeometry(
                factory.createParticleLine(start, end, 5, new Vector(0, 1, 0)),
                Color.fromRGB(255, 255, 0),
                world);
    }

    /**
     * Get the closest damageable entity to the given entity
     *
     * @param entity          to get close entities from
     * @param previousTargets a list of previous targets (makes sure future targets are unique)
     * @return the closest damageable entity
     */
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
