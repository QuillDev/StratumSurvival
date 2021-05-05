package tech.quilldev.CustomItemsv2.Effects;

import net.kyori.adventure.text.Component;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HealPlayerEffect extends Effect{
    public void execute(Event event, float modifier) {
        final var player = helper.getLivingEntity(event);
        final var maxHP = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (maxHP == null) return;
        var hpToSet = player.getHealth() + modifier;
        if ((player.getHealth() + modifier) >= maxHP.getValue()) {
            hpToSet = maxHP.getValue();
        }

        player.setHealth(hpToSet);

        //player.sendMessage(Component.text(modifier));
    }
}
