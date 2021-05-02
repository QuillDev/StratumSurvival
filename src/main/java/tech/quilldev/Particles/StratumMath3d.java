package tech.quilldev.Particles;

import com.mojang.datafixers.util.Pair;

import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StratumMath3d {

    /**
     * Construct a line with N subdivisions
     * @param pointA first point in the line
     * @param pointB second point in the line
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

    /**
     * Removes duplicate points from an array list
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
     * @param source the pair to divide into new pairs
     * @return the new pairs
     */
    public Pair<Pair<Vector, Vector>, Pair<Vector, Vector>> subdivide(Pair<Vector, Vector> source) {
        final var midPoint = source.getFirst().getMidpoint(source.getSecond());
        return new Pair<>(new Pair<>(source.getFirst(), midPoint), new Pair<>(source.getSecond(), midPoint));
    }

}
