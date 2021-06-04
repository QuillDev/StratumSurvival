package moe.quill.stratumsurvival.Crafting.Items.Effects;

import org.bukkit.attribute.Attribute;
import org.bukkit.event.Event;

public class HealPlayerEffect extends Effect {
    public void execute(Event event, float modifier) {
        final var player = helper.getLivingEntity(event);
        if (player == null) return;
        final var maxHP = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (maxHP == null) return;
        var hpToSet = player.getHealth() + modifier;
        if ((player.getHealth() + modifier) >= maxHP.getValue()) {
            hpToSet = maxHP.getValue();
        }

        player.setHealth(hpToSet);
    }
}
