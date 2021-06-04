package moe.quill.stratumsurvival.Utils;

public class TickHelper {

    public static final long THIRTY_MINUTES = minToTick(30);
    public static final long ONE_HOUR = THIRTY_MINUTES * 2L;

    private static final long TICK_RATE = 20L;

    public static long secToTick(long seconds) {
        return seconds * TICK_RATE;
    }

    public static long minToTick(long mins) {
        return mins * 60 * TICK_RATE;
    }

    public static long tickToMin(long ticks) {
        return ticks / 60 / TICK_RATE;
    }

    public static long tickToSec(long ticks) {
        return ticks / TICK_RATE;
    }
}
