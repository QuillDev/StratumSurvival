package tech.quilldev.CustomItemsv2.Effects;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CloakEffect extends Effect{

    public void execute(Event event) {

        final  var duration = 45;
        final var player = helper.getLivingEntity(event);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, duration, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, duration + 15, 1));
    }
}
