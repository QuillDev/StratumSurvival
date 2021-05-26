package moe.quill.Crafting.Items.Effects;

import org.bukkit.Location;

public class TimeSetEffect extends Effect {
    public void execute(Location location, long ticks) {
        location.getWorld().setFullTime(ticks);
    }
}
