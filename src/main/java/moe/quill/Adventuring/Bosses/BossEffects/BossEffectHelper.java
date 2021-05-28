package moe.quill.Adventuring.Bosses.BossEffects;

import moe.quill.Crafting.Items.Effects.EffectHelpers.EffectHelper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BossEffectHelper extends EffectHelper {

    public ArrayList<Player> getNearbyPlayers(LivingEntity boss, double radius){
        ArrayList<Player> players = new ArrayList<Player>(boss.getLocation().getNearbyPlayers(radius));
        return players;
    }
}
