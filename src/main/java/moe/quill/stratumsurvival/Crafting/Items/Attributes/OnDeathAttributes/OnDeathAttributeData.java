package moe.quill.stratumsurvival.Crafting.Items.Attributes.OnDeathAttributes;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;

public class OnDeathAttributeData {


    private final Player player;
    private final Entity target;
    private final EntityDeathEvent event;

    public OnDeathAttributeData(Player player, Entity target, EntityDeathEvent event) {
        this.player = player;
        this.target = target;
        this.event = event;
    }

    public Player getPlayer() {
        return player;
    }

    public Entity getTarget() {
        return target;
    }

    public EntityDeathEvent getEvent() {
        return event;
    }
}
