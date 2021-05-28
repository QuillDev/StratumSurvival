package moe.quill.Adventuring.Bosses.BossAttacks;

import moe.quill.Adventuring.Bosses.BossEffects.PotionBasedBossEffect;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LevitatePlayersAttack extends BossAttack{
    private static final PotionBasedBossEffect BossEffect = new PotionBasedBossEffect();
    private static final PotionEffectType potionEffect = PotionEffectType.LEVITATION;

    @Override
    public void execute(LivingEntity boss) {
        BossEffect.execute(boss, potionEffect, 30);
    }
}
