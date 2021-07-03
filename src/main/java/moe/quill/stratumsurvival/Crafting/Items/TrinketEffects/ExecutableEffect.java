package moe.quill.stratumsurvival.Crafting.Items.TrinketEffects;

import org.bukkit.event.Event;

import java.util.Collection;

public interface ExecutableEffect {
    void execute(Event event);

    Collection<Event> allowedEvents();
}
