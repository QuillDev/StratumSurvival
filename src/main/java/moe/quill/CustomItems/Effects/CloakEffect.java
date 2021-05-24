package moe.quill.CustomItems.Effects;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CloakEffect extends Effect {

    public void execute(Event event, int duration) {
        if (!(event instanceof PlayerInteractEvent)) return;
        final var player = helper.getLivingEntity(event);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, duration, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, duration + 15, 1));
    }
}
