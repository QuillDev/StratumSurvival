package tech.quilldev.Particles;

import com.mojang.datafixers.util.Pair;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class StratumMath3d {

    /**
     * Construct a line with N subdivisions
     *
     * @param pointA     first point in the line
     * @param pointB     second point in the line
     * @param resolution dictates how many passes the line will generate points from
     * @return an arraylist of points on the given line
     */
    public ArrayList<Vector> constructLine(Vector pointA, Vector pointB, int resolution) {
        //If there are no divisions
        if (resolution == 0) {
            return new ArrayList<>(Arrays.asList(pointA, pointB));
        }

        var pairs = new ArrayList<>(Collections.singletonList(new Pair<>(pointA, pointB)));

        for (var i = 0; i < resolution; i++) {
            var newPairs = new ArrayList<Pair<Vector, Vector>>();

            pairs.forEach(p -> {
                final var newPair = subdivide(p);
                newPairs.addAll(
                        Arrays.asList(
                                newPair.getFirst(),
                                newPair.getSecond()
                        )
                );
            });
            pairs = newPairs;
        }

        //get all points
        final var points = new ArrayList<Vector>();

        //Map the pairs to an arraylist
        pairs.forEach(pair -> {
            points.addAll(Arrays.asList(pair.getSecond(), pair.getFirst()));
        });

        return removeDuplicates(points);
    }

    public ArrayList<Vector> constructBoundingBox(BoundingBox box, int resolution) {
        final var x1 = box.getMinX();
        final var y1 = box.getMinY();
        final var z1 = box.getMinZ();
        final var x2 = box.getMaxX();
        final var y2 = box.getMaxY();
        final var z2 = box.getMaxZ();

        final var backBottomLeft = new Vector(x1, y1, z1);
        final var backBottomRight = new Vector(x2, y1, z1);
        final var backTopLeft = new Vector(x1, y2, z1);
        final var backTopRight = new Vector(x2, y2, z1);
        final var frontBottomLeft = new Vector(x1, y1, z2);
        final var frontBottomRight = new Vector(x2, y1, z2);
        final var frontTopLeft = new Vector(x1, y2, z2);
        final var frontTopRight = new Vector(x2, y2, z2);

        final var bottomLeftLengthLine = constructLine(backBottomLeft, frontBottomLeft, resolution);
        final var bottomRightLengthLine = constructLine(backBottomRight, frontBottomRight, resolution);
        final var topLeftLengthLine = constructLine(backTopLeft, frontTopLeft, resolution);
        final var topRightLengthLine = constructLine(backTopRight, frontTopRight, resolution);
        final var bottomBackWidthLine = constructLine(backBottomLeft, backBottomRight, resolution);
        final var topBackWidthLine = constructLine(backTopLeft, backTopRight, resolution);
        final var bottomFrontWidthLine = constructLine(frontBottomLeft, frontBottomRight, resolution);
        final var topFrontWidthLine = constructLine(frontTopLeft, frontTopRight, resolution);
        final var leftFrontVerticalConnector = constructLine(frontBottomLeft, frontTopLeft, resolution);
        final var rightFrontVerticalConnector = constructLine(frontBottomRight, frontTopRight, resolution);
        final var leftBackVerticalConnector = constructLine(backBottomLeft, backTopLeft, resolution);
        final var rightBackVerticalConnector = constructLine(backBottomRight, backTopRight, resolution);

        final var list = new ArrayList<Vector>();
        list.addAll(rightBackVerticalConnector);
        list.addAll(rightFrontVerticalConnector);
        list.addAll(leftBackVerticalConnector);
        list.addAll(leftFrontVerticalConnector);
        list.addAll(bottomFrontWidthLine);
        list.addAll(bottomBackWidthLine);
        list.addAll(topFrontWidthLine);
        list.addAll(topBackWidthLine);
        list.addAll(topLeftLengthLine);
        list.addAll(topRightLengthLine);
        list.addAll(bottomLeftLengthLine);
        list.addAll(bottomRightLengthLine);

        return removeDuplicates(list);
    }

    /**
     * Convert raw vectors into locations in the current minecraft world
     *
     * @param world   to adjust locations for
     * @param vectors to convert into locations
     * @param offset  vector containing offsets for the particles
     * @return the adjusted vectors
     */
    public ArrayList<Location> convertVectorsToLocations(World world, ArrayList<Vector> vectors, Vector offset) {
        return vectors.stream()
                .map(vec -> {
                            vec.add(offset); //add the offset vector to the main vector
                            return new Location(world, vec.getX(), vec.getY(), vec.getZ());
                        }
                ).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Removes duplicate points from an array list
     *
     * @param list to check for duplicates
     * @return a list without duplicates
     */
    public ArrayList<Vector> removeDuplicates(ArrayList<Vector> list) {
        final var unique = new ArrayList<Vector>();
        list.forEach(point -> {
            if (unique.contains(point)) return;
            unique.add(point);
        });
        return unique;
    }

    /**
     * Subdivides pairs into a group of two new pairs
     *
     * @param source the pair to divide into new pairs
     * @return the new pairs
     */
    public Pair<Pair<Vector, Vector>, Pair<Vector, Vector>> subdivide(Pair<Vector, Vector> source) {
        final var midPoint = source.getFirst().getMidpoint(source.getSecond());
        return new Pair<>(new Pair<>(source.getFirst(), midPoint), new Pair<>(source.getSecond(), midPoint));
    }

}
