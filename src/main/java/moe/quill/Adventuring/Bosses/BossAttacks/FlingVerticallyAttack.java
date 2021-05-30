package moe.quill.Adventuring.Bosses.BossAttacks;

import moe.quill.Adventuring.Bosses.BossEffects.VelocityBasedBossEffect.FlingVerticallyBossEffect;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.LivingEntity;

public class FlingVerticallyAttack extends BossAttack {

    private final FlingVerticallyBossEffect flingVerticallyBossEffect = new FlingVerticallyBossEffect();

    public FlingVerticallyAttack() {
        super(Component.text("The boss flings you away!"));
    }

    @Override
    public void execute(LivingEntity boss) {
        this.flingVerticallyBossEffect.execute(boss, 4);
    }
}
