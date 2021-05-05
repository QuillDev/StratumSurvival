package tech.quilldev.CustomItemsv2.Effects;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;
import tech.quilldev.Particles.ParticleFactory;

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
        final var previousTargets = new ArrayList<Entity>(Collections.singletonList(player));

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
