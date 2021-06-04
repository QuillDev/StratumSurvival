package moe.quill.Adventuring.Bosses.BossAttacks;

import moe.quill.Adventuring.Bosses.BossEffects.SpawnEnemiesBossEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffectType;

public class SpawnZombiesAttack extends BossAttack{
    private static final SpawnEnemiesBossEffect BossEffect = new SpawnEnemiesBossEffect();

    @Override
    public void execute(LivingEntity boss) {
        BossEffect.execute(boss, EntityType.ZOMBIE, 1);
    }
}
