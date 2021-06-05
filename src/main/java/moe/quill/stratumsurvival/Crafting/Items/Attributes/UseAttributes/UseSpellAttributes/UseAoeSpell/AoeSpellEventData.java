package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseAoeSpell;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseEventData;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.SpellEventData;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Collection;
import java.util.stream.Collectors;

public class AoeSpellEventData extends SpellEventData {

    private Collection<LivingEntity> nearbyEntities;

    public AoeSpellEventData(PlayerInteractEvent event, Player player, Action action, float potency, float range, boolean pvp) {
        super(event, player, action, potency);
        this.nearbyEntities = player.getLocation().getNearbyLivingEntities(range * (1 + potency));

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

    public AoeSpellEventData(SpellEventData spellEventData, float range, boolean pvp) {
        this(spellEventData.getEvent(), spellEventData.getPlayer(), spellEventData.getEvent().getAction(), spellEventData.getPotency(), range, pvp);
    }

    public Collection<LivingEntity> getNearbyEntities() {
        return nearbyEntities;
    }
}
