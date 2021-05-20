package tech.quilldev.CustomItemsv2.Effects;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tech.quilldev.CustomItemsv2.Effects.EffectHelpers.EffectHelper;

public class PotionBasedEffect extends Effect{
    public void execute(Event event, PotionEffectType type, LivingEntity target, int duration) {
        var effect = new PotionEffect(type, duration, 1);
        effect.apply(target);
    }
}
