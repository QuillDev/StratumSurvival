package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseAoeSpell;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseEventData;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Collection;
import java.util.stream.Collectors;

public class AoeSpellEventData extends UseEventData {

    private Collection<LivingEntity> nearbyEntities;

    public AoeSpellEventData(PlayerInteractEvent event, Player player, Action action, float range, boolean pvp) {
        super(event, player, action);
        this.nearbyEntities = player.getLocation().getNearbyLivingEntities(range);

        //If this skill is a pvp skill, check if pvp is enabled and act accordingly
        if (pvp) {
            //If we're not in a pvp world  filter out players
            if (!player.getWorld().getPVP()) {
                this.nearbyEntities = nearbyEntities.stream()
                        .filter(ent -> !(ent instanceof Player))
                        .collect(Collectors.toList());
            }
        }
    }

    public Collection<LivingEntity> getNearbyEntities() {
        return nearbyEntities;
    }
}
