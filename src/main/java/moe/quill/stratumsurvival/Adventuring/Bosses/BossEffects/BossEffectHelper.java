package moe.quill.stratumsurvival.Adventuring.Bosses.BossEffects;

import moe.quill.stratumsurvival.Crafting.Items.Effects.EffectHelpers.EffectHelper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BossEffectHelper extends EffectHelper {

    public ArrayList<Player> getNearbyPlayers(LivingEntity boss, double radius) {
        return new ArrayList<>(boss.getLocation().getNearbyPlayers(radius));
    }

    public ArrayList<Player> getNearbyPlayers(LivingEntity boss) {
        return new ArrayList<>(boss.getLocation().getNearbyPlayers(35));
    }
}
