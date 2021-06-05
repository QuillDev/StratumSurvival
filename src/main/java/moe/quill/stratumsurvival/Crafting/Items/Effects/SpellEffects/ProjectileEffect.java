package moe.quill.stratumsurvival.Crafting.Items.Effects.SpellEffects;

import moe.quill.stratumsurvival.Crafting.Items.Effects.Effect;
import moe.quill.stratumsurvival.Particles.ParticleFactory;
import org.bukkit.Color;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.stream.Collectors;

public class ProjectileEffect extends Effect {

    private final ParticleFactory particleFactory = new ParticleFactory();

    public void execute(Player player, int range, double damage, boolean pierce, Color color) {
        final var targetLoc = player.getTargetBlock(range);
        if (targetLoc == null) return;

        //Get player location + world information
        final var playerLocation = player.getEyeLocation();
        final var world = player.getWorld();

        //The radius of hit boxes on the later
        final var radius = .6;
        //create the ray between the player & their target
        final var ray = particleFactory.createParticleLine(playerLocation, targetLoc.getLocation(), range / 2, new Vector(0, 0, 0));

        //Get nearby living entities
        var targets = playerLocation.getNearbyEntitiesByType(LivingEntity.class, 5);
        targets.remove(player);
        if (!world.getPVP()) {
            targets = targets.stream()
                    .filter(entity -> !(entity instanceof Player))
                    .collect(Collectors.toList());
        }


        //Draw the particles
        particleFactory.constructParticleGeometry(
                ray,
                color,
                player.getWorld()
        );

        //Iterate through each
        //TODO: If we can figure out a way to geometrically draw ONE hit box we go to O(n)
        for (final var point : ray) {
            final var hitBox = new BoundingBox(
                    point.getX() - radius,
                    point.getY() + radius,
                    point.getZ() - radius,
                    point.getX() + radius,
                    point.getY() - radius,
                    point.getZ() + radius
            );

            //Check if the targets hit box overlaps with the hit box, if it does, do the damage
            for (final var target : targets) {
                if (!target.getBoundingBox().overlaps(hitBox)) continue;
                target.damage(damage, player);

                //If we don't have a piercing gun
                if (!pierce) {
                    return;
                }
            }
        }


    }
}
