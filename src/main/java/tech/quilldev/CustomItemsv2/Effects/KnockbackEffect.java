package tech.quilldev.CustomItemsv2.Effects;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;

public class KnockbackEffect extends Effect{

    public void execute(Event event, float modifier) {
        final var player = helper.getLivingEntity(event);
        player.setVelocity(player.getLocation().getDirection().multiply(-modifier));
    }



}
