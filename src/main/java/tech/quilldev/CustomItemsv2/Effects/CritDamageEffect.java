package tech.quilldev.CustomItemsv2.Effects;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

public class CritDamageEffect extends Effect {
    public void execute(Event sourceEvent, float modifier) {
        //Get all of the data we need for to execute the event
        final var player = helper.getLivingEntity(sourceEvent);
        final var baseDamage = helper.getEventDamage(sourceEvent);
        var entity = helper.getTargetLivingEntity(sourceEvent);
        if (player == null || baseDamage == null || entity == null) return;

        final var event = (EntityDamageByEntityEvent) sourceEvent;

        event.setDamage(event.getDamage() * 2);


        //TODO: replace with particles for CritDamageEffect

    }
}
