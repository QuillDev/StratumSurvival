package tech.quilldev.CustomItems.Attributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tech.quilldev.CustomItems.Attributes.Attribute;
import tech.quilldev.CustomItems.Effects.SpawnEntityEffect;
import tech.quilldev.CustomItems.Effects.SpawnLingeringPotionCloudEffect;

public abstract class LingeringPotionOnDeathAttribute extends OnDeathAttribute {

    SpawnLingeringPotionCloudEffect spawnLingeringPotionCloudEffect = new SpawnLingeringPotionCloudEffect();
    PotionEffect potionEffect;

    public LingeringPotionOnDeathAttribute(NamespacedKey key, PotionEffect potionEffect, Component displayName) {
        super(key,
                displayName,
                .2f,
                .1f,
                .75f
        );
        this.potionEffect = potionEffect;
    }

    @Override
    public String dataFormat(float value) {
        return attributeFormatter.formatPercent(value);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;

        var target = eventData.getTarget();

        if (modifier < rand.nextFloat()) return;
        spawnLingeringPotionCloudEffect.execute(sourceEvent, target.getLocation(),potionEffect);
    }
}
