package tech.quilldev.CustomItemsv2.Attributes.AttackAttributes;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AttackEventData {

    public Player player;
    public LivingEntity target;
    public EntityDamageByEntityEvent event;

    public AttackEventData(Player player, LivingEntity target, EntityDamageByEntityEvent event) {
        this.player = player;
        this.target = target;
        this.event = event;
    }

    public Player getPlayer() {
        return player;
    }

    public LivingEntity getTarget() {
        return target;
    }

    public EntityDamageByEntityEvent getEvent() {
        return event;
    }
}
