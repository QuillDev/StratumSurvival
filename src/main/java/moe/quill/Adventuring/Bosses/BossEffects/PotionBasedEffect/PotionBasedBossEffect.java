package moe.quill.Adventuring.Bosses.BossEffects.PotionBasedEffect;

import moe.quill.Adventuring.Bosses.BossEffects.BossEffect;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionBasedBossEffect extends BossEffect {

    public void execute(LivingEntity boss, PotionEffectType type, int duration) {
        var effect = new PotionEffect(type, duration, 1);

        for (LivingEntity player : helper.getNearbyPlayers(boss, 35)) {
            effect.apply(player);
        }
    }
}
