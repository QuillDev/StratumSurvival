package tech.quilldev.CustomItems.Effects;

import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class TimeSetEffect extends Effect{
    public void execute(Event sourceEvent, Location location, long ticks) {
        location.getWorld().setTime(ticks);
    }
}
