package moe.quill.CustomItems.Effects;

import org.bukkit.Location;
import org.bukkit.event.Event;

public class TimeSetEffect extends Effect{
    public void execute(Event sourceEvent, Location location, long ticks) {
        location.getWorld().setTime(ticks);
    }
}
