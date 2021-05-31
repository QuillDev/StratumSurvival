package moe.quill.stratumsurvival.Crafting.Items.Effects;

import org.bukkit.Location;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;

public class SpawnLingeringPotionCloudEffect extends Effect{


    public void execute(Event sourceEvent, Location location, PotionEffect potionEffect, float radius, int duration, int durationOnUse) {
        AreaEffectCloud cloud = (AreaEffectCloud) location.getWorld().spawnEntity(location, EntityType.AREA_EFFECT_CLOUD);
        cloud.addCustomEffect(potionEffect, true);
        cloud.setDuration(duration);
        cloud.setRadius(radius);
        cloud.setDurationOnUse(-durationOnUse);
    }
}
