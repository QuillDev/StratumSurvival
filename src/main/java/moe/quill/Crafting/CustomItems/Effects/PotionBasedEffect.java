package moe.quill.Crafting.CustomItems.Effects;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionBasedEffect extends Effect{
    public void execute(Event event, PotionEffectType type, LivingEntity target, int duration) {
        var effect = new PotionEffect(type, duration, 1);
        effect.apply(target);
    }
}
