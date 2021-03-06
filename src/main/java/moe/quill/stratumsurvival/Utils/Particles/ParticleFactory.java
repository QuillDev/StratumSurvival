package moe.quill.stratumsurvival.Utils.Particles;

import com.mojang.datafixers.util.Pair;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ParticleFactory {
    private static final StratumMath3d smath3d = new StratumMath3d();

    /**
     * Create a line of particles and return all locations on that line
     *
     * @param locA       line start location
     * @param locB       line end location
     * @param resolution determines how many points will be in the line
     * @param offset     how far to offset the Y axis of the line
     * @return all locations that comprise the given line attributes
     */
    public ArrayList<Location> createParticleLine(Location locA, Location locB, int resolution, Vector offset) {
        final var linePoints = smath3d.constructLine(locA.toVector(), locB.toVector(), resolution);
        return smath3d.convertVectorsToLocations(locA.getWorld(), linePoints, offset);
    }

    public Collection<Pair<Location, Location>> createLineSegmentList(Location start, Location end, int divisions) {
        final var vecSegments = smath3d.createLineSegments(start.toVector(), end.toVector(), divisions);
        return vecSegments.stream()
                .map(segment -> new Pair<>(segment.getFirst().toLocation(start.getWorld()), segment.getSecond().toLocation(start.getWorld())))
                .collect(Collectors.toList());
    }

    /**
     * @param boundingBox box to generate geometry from
     * @param world       to generate geometry in
     * @return the geometry of the shape
     */
    public ArrayList<Location> createHitboxGeometry(BoundingBox boundingBox, World world) {
        final var points = smath3d.constructBoundingBox(boundingBox, 5);
        return smath3d.convertVectorsToLocations(world, points, new Vector());
    }

    public ArrayList<Location> createCircleGeometry(Location center, float radius, int resolution, Vector offset) {
        final var points = smath3d.constructCircle(center.toVector(), radius, resolution);
        return smath3d.convertVectorsToLocations(center.getWorld(), points, offset);
    }

    public ArrayList<Location> createConcentricCircleGeometry(Location center, float maxRadius, int resolution, int rings, Vector offset) {
        final var points = new ArrayList<Location>();

        //Create evenly spaced concentric rings
        for (int ring = 0; ring < rings; ring++) {
            points.addAll(createCircleGeometry(center, maxRadius / (float) (ring + 1), resolution, offset));
        }

        return points;
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
    public void constructParticleGeometry(ArrayList<Location> points, Particle particle, Vector noise, World
            world) {
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
        points.forEach(p -> world.spawnParticle(Particle.REDSTONE, p, 1, 0, 0, 0, dust));
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
