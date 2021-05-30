package moe.quill.Adventuring.Bosses.BossAttacks;

import moe.quill.Adventuring.Bosses.BossEffects.PotionBasedEffect.PotionBasedBossEffect;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffectType;

public class LevitatePlayersAttack extends BossAttack {
    private static final PotionBasedBossEffect BossEffect = new PotionBasedBossEffect();
    private static final PotionEffectType potionEffect = PotionEffectType.LEVITATION;

    public LevitatePlayersAttack() {
        super(Component.text("You're flung into the air!"));
    }

    @Override
    public void execute(LivingEntity boss) {
        BossEffect.execute(boss, potionEffect, 30);
    }
}
