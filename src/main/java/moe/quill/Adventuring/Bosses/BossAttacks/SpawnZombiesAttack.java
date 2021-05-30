package moe.quill.Adventuring.Bosses.BossAttacks;

import moe.quill.Adventuring.Bosses.BossEffects.SummonBasedBossEffect.SpawnEnemiesBossEffect;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class SpawnZombiesAttack extends BossAttack {
    private static final SpawnEnemiesBossEffect BossEffect = new SpawnEnemiesBossEffect();

    public SpawnZombiesAttack() {
        super(Component.text("The boss has summoned minions!"));
    }

    @Override
    public void execute(LivingEntity boss) {
        BossEffect.execute(boss, EntityType.ZOMBIE, 1);
    }
}
