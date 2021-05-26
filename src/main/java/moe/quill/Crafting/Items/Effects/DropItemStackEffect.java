package moe.quill.Crafting.Items.Effects;

import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class DropItemStackEffect extends Effect{
    public void execute(Event sourceEvent, Location location,ItemStack itemStack) {
        location.getWorld().dropItemNaturally(location, itemStack);
    }
}
