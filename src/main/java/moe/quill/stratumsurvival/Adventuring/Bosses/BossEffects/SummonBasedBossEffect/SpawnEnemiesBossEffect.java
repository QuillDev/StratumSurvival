package moe.quill.stratumsurvival.Adventuring.Bosses.BossEffects.SummonBasedBossEffect;

import moe.quill.stratumsurvival.Adventuring.Bosses.BossEffects.BossEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class SpawnEnemiesBossEffect extends BossEffect {

    public void execute(LivingEntity boss, EntityType enemy, int count) {

        for (int i = 0; i < count; i++) {
            boss.getWorld().spawnEntity(boss.getLocation(), enemy);
        }
    }
}
