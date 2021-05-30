package moe.quill.Adventuring.Bosses.BossEffects.VelocityBasedBossEffect;

import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class FlingVerticallyBossEffect extends VelocityBasedBossEffect {
    public void execute(LivingEntity boss, int magnitude) {
        final var nearbyPlayers = helper.getNearbyPlayers(boss);
        nearbyPlayers.forEach(player -> {
            final var curVel = player.getVelocity();
            //Direction between the boss and the player
            final var direction = player.getLocation().subtract(boss.getLocation().toVector()).toVector()
                    .normalize();

            //Add some flare to it by making sure it tosses them into the air
            direction.setY(Math.max(direction.getY(), .5));
            direction.multiply(magnitude);
            player.setVelocity(direction);
        });
    }
}
