package tech.quilldev.CustomItems.Effects;

import org.bukkit.Location;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;

public class SpawnLingeringPotionCloudEffect extends Effect{


    public void execute(Event sourceEvent, Location location, PotionEffect potionEffect) {
        AreaEffectCloud cloud = (AreaEffectCloud) location.getWorld().spawnEntity(location, EntityType.AREA_EFFECT_CLOUD);
        cloud.addCustomEffect(potionEffect, true);
        cloud.setDuration(400);
        cloud.setRadius(1);
        cloud.setDurationOnUse(-400);
    }
}
