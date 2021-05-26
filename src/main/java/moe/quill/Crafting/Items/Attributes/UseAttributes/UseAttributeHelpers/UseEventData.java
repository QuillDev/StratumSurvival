package moe.quill.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class UseEventData {

    private final PlayerInteractEvent event;
    private final Player player;
    private final Action action;

    public UseEventData(PlayerInteractEvent event, Player player, Action action) {
        this.event = event;
        this.player = player;
        this.action = action;
    }

    public PlayerInteractEvent getEvent() {
        return event;
    }

    public Player getPlayer() {
        return player;
    }
}
