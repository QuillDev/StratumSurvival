package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseEventData;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpellEventData extends UseEventData {

    private final float potency;

    public SpellEventData(PlayerInteractEvent event, Player player, Action action, float potency) {
        super(event, player, action);
        this.potency = potency;
    }

    public SpellEventData(UseEventData eventData, float potency) {
        this(eventData.getEvent(), eventData.getPlayer(), eventData.getEvent().getAction(), potency);
    }

    public float getPotency() {
        return potency;
    }
}
