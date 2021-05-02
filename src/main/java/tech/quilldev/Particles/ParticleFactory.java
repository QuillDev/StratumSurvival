package tech.quilldev.Particles;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ParticleFactory {
    private static StratumMath3d smath3d = new StratumMath3d();

    /**
     * Create a line of particles and return all locations on that line
     * @param locA       line start location
     * @param locB       line end location
     * @param resolution determines how many points will be in the line
     * @param yOffset    how far to offset the Y axis of the line
     * @return all locations that comprise the given line attributes
     */
    public ArrayList<Location> createParticleLine(Location locA, Location locB, int resolution, int yOffset) {
        final var linePoints = smath3d.constructLine(locA.toVector(), locB.toVector(), resolution);
        linePoints.forEach(System.out::println);
        return linePoints
                .stream()
                .map(point -> new Location(locA.getWorld(), point.getX(), point.getY() + yOffset, point.getZ()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Construct the given particle geometry from the given points
     *
     * @param points   of the geometry
     * @param particle to make geometry out of
     * @param world    to spawn particle in
     */
    public void constructParticleGeometry(ArrayList<Location> points, Particle particle, World world) {
        points.forEach(p -> world.spawnParticle(particle, p, 1));
    }

    /**
     * Construct the given particle geometry with a given particle and noise
     *
     * @param points   to construct the geometry from
     * @param particle to use for construction
     * @param noise    amount of noise on each particle
     * @param world    to spawn in
     */
    public void constructParticleGeometry(ArrayList<Location> points, Particle particle, Vector noise, World world) {
        points.forEach(p -> world.spawnParticle(particle, p, 1, noise.getX(), noise.getY(), noise.getZ()));
    }

    /**
     * Construct the given particle geometry with the given color
     *
     * @param points to draw geometry from
     * @param color  to make particles
     * @param world  to spawn particles in
     */
    public void constructParticleGeometry(ArrayList<Location> points, Color color, World world) {
        Particle.DustOptions dust = new Particle.DustOptions(color, 1);
        points.forEach(p -> world.spawnParticle(Particle.REDSTONE, p, 1, .3, .3, .3, dust));
    }

    /**
     * Construct the given particle geometry with the given color and noise
     *
     * @param points to build geometry from
     * @param color  to make the geometry
     * @param noise  variation in the geometry
     * @param world  to make the geometry in
     */
    public void constructParticleGeometry(ArrayList<Location> points, Color color, Vector noise, World world) {
        Particle.DustOptions dust = new Particle.DustOptions(color, 1);
        points.forEach(p -> world.spawnParticle(Particle.REDSTONE, p, 1, noise.getX(), noise.getY(), noise.getZ(), dust));
    }
}
