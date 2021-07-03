package moe.quill.stratumsurvival.Expiramental;

import java.util.Random;

public interface LevelTool {

    Random RANDOM = new Random();

    /**
     * Get a random level for the item
     *
     * @return the level for the item
     */
    default int getRandomLevel(float levelRate, float maxLevel) {
        var level = 1;
        for (; level < maxLevel; level++) {
            if (levelRate < RANDOM.nextFloat()) return level;
        }
        return level;
    }
}
