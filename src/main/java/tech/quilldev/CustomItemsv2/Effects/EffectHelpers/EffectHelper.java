package tech.quilldev.CustomItemsv2.Effects.EffectHelpers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class EffectHelper {

    public LivingEntity getLivingEntity(Event event) {
        // Handle entity damaged by entity event
        if (event instanceof EntityDamageByEntityEvent) {
            return (LivingEntity) ((EntityDamageByEntityEvent) event).getDamager();
        }
        if (event instanceof EntityDeathEvent) {
            return ((EntityDeathEvent) event).getEntity().getKiller();
        }
        if (event instanceof EntityInteractEvent) {
            return (LivingEntity) ((EntityInteractEvent) event).getEntity();
        }

        return null;
    }

    public Entity getTargetLivingEntity(Event event) {
        // Handle entity damaged by entity event
        if (event instanceof EntityDamageByEntityEvent) {
            return ((EntityDamageByEntityEvent) event).getEntity();
        }
        if (event instanceof EntityDeathEvent) {
            return ((EntityDeathEvent) event).getEntity();
        }
        if (event instanceof PlayerInteractAtEntityEvent) {
            return ((PlayerInteractAtEntityEvent) event).getRightClicked();
        }
        return null;
    }

    public Double getEventDamage(Event event) {
        // Handle entity damaged by entity event
        if (event instanceof EntityDamageByEntityEvent) {
            return ((EntityDamageByEntityEvent) event).getDamage();
        }
        return null;
    }
}
