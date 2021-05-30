package moe.quill.Adventuring.Bosses.BossEffects.SummonBasedBossEffect;

import moe.quill.Adventuring.Bosses.BossEffects.BossEffect;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class SpawnEnemiesBossEffect extends BossEffect {

    public void execute(LivingEntity boss, EntityType enemy, int count) {

        for (int i = 0; i < count; i++) {
            boss.getWorld().spawnEntity(boss.getLocation(), enemy);
        }
    }
}
