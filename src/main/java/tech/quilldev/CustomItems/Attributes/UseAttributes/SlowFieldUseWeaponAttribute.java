package tech.quilldev.CustomItems.Attributes.UseAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tech.quilldev.CustomItems.Attributes.OnDeathAttributes.LingeringPotionOnDeathAttribute;
import tech.quilldev.CustomItems.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import tech.quilldev.CustomItems.Effects.CloakEffect;
import tech.quilldev.CustomItems.Effects.KnockbackEffect;
import tech.quilldev.CustomItems.Effects.SpawnLingeringPotionCloudEffect;

public class SlowFieldUseWeaponAttribute extends UseAttribute {

    SpawnLingeringPotionCloudEffect spawnLingeringPotionCloudEffect = new SpawnLingeringPotionCloudEffect();

    public SlowFieldUseWeaponAttribute(NamespacedKey key) {
        super(key,
                Component.text("Slowing Field").color(TextColor.color(0x6B8FCB)),
                0f,
                500L);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var useEventData = getEventData(sourceEvent, true, true);
        if (useEventData == null) return;

        var player = useEventData.getPlayer();

        spawnLingeringPotionCloudEffect.execute(sourceEvent,player.getLocation(),
                new PotionEffect(PotionEffectType.SLOW,35,2),
                12,
                100,
                0
                );
    }

}
