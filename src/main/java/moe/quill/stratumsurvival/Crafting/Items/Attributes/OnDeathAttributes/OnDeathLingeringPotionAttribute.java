package moe.quill.stratumsurvival.Crafting.Items.Attributes.OnDeathAttributes;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.Attribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Effects.SpawnLingeringPotionCloudEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;

public abstract class OnDeathLingeringPotionAttribute extends OnDeathAttribute {

    SpawnLingeringPotionCloudEffect spawnLingeringPotionCloudEffect = new SpawnLingeringPotionCloudEffect();
    PotionEffect potionEffect;
    float radius;
    int duration;
    int durationOnUse;

    public OnDeathLingeringPotionAttribute
            (
                    Plugin plugin,
                    MaterialManager materialManager,
                    IKeyManager keyManager,
                    ISerializer serializer,
                    ItemLists itemLists,
                    AttributeKey key,
                    PotionEffect potionEffect,
                    Component displayName,
                    float radius,
                    int duration,
                    int durationOnUse
            ) {
        super(
                plugin,
                materialManager,
                keyManager,
                serializer,
                itemLists,
                key,
                displayName,
                .2f,
                .1f,
                .75f
        );
        this.potionEffect = potionEffect;
        this.radius = radius;
        this.duration = duration;
        this.durationOnUse = durationOnUse;
    }

    @Override
    public String dataFormat(float value) {
        return Attribute.attributeFormatter.formatPercent(value);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;

        var target = eventData.getTarget();

        if (modifier < Attribute.rand.nextFloat()) return;
        spawnLingeringPotionCloudEffect.execute(sourceEvent, target.getLocation(), potionEffect, radius, duration, durationOnUse);
    }
}
