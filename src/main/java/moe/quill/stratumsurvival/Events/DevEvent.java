package moe.quill.stratumsurvival.Events;

import com.google.inject.Inject;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;

public class DevEvent implements Listener {

    private final Plugin plugin;

    @Inject
    public DevEvent(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void devEvent(PlayerInteractEvent event) {

        final var player = event.getPlayer();

        if (!player.getInventory().getItemInMainHand().getType().equals(Material.WOODEN_HOE)) return;

        final var targetBlock = player.getTargetBlock(15);
        if (targetBlock == null) return;
        final var targetLocation = targetBlock.getLocation();
//        drawParticlesAtLocations(getRayLocations(player.getEyeLocation(), targetLocation, 1), Color.AQUA, 1);
//        drawParticlesWithVelocityAtLocations(
//                getRayLocations(player.getEyeLocation(), targetLocation, 1),
//                Color.RED,
//                1, 2
//        );

        drawParticlesWithVelocityAtLocations(
                getRayLocations(player.getEyeLocation(), targetLocation, 2),
                Color.RED,
                1, 2
        );
    }

    public void drawParticlesWithVelocityAtLocations(AbstractList<Location> locations, Color color, int count, long ticksPerDraw) {

        //Iterate through all locations in the list
        for (int idx = 0; idx < locations.size(); idx++) {
            final var location = locations.get(idx); //get the location

            //Schedule a task for when the particle is supposed to spawn and them summon a particle at that location
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                location.getWorld().spawnParticle(Particle.REDSTONE, location, count, new Particle.DustOptions(color, 1));
            }, ticksPerDraw * idx);
        }
    }

    /**
     * Draw the given particle for each location given
     *
     * @param locations to spawn the particles at
     * @param color     to spawn the particle as
     * @param count     amount of particles to spawn
     */
    public void drawParticlesAtLocations(Collection<Location> locations, Color color, int count) {
        World world = null;
        for (final var location : locations) {
            if (world == null) world = location.getWorld(); //set the world if it's not set yet
            world.spawnParticle(Particle.REDSTONE, location, count, new Particle.DustOptions(color, 1));
        }
    }

    /**
     * Get all locations in a ray between the start and end locations
     *
     * @param start location to being drawing from
     * @param end   location to end drawing at
     * @param delta spacing between each location
     * @return a list of locations between the start and end point
     */
    public ArrayList<Location> getRayLocations(Location start, Location end, float delta) {
        final var world = start.getWorld(); //get the world we're working in

        final var distance = start.distance(end); //get the distance between the start and end

        //Get the vectors of the start + end locations
        final var curPosVec = start.toVector();
        final var endVector = end.toVector();

        final var deltaVector = endVector.subtract(curPosVec).normalize().multiply(delta);

        var covered = 0; //distance currently covered out of max
        final var locations = new ArrayList<Location>(); //create our location store list
        for (; covered < distance; curPosVec.add(deltaVector)) {
            locations.add(new Location(world, curPosVec.getX(), curPosVec.getY(), curPosVec.getZ()));
            covered += delta;
        }

        return locations;
    }
}
