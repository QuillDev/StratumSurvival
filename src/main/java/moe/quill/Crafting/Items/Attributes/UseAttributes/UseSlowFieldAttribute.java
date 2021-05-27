package moe.quill.Crafting.Items.Attributes.UseAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import moe.quill.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import moe.quill.Crafting.Items.Effects.SpawnLingeringPotionCloudEffect;

public class UseSlowFieldAttribute extends UseAttribute {

    SpawnLingeringPotionCloudEffect spawnLingeringPotionCloudEffect = new SpawnLingeringPotionCloudEffect();

    public UseSlowFieldAttribute() {
        super(AttributeKey.USE_SLOW_FIELD_ATTRIBUTE,
                Component.text("Slowing Field").color(TextColor.color(0x6B8FCB)),
                0f,
                500L);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var useEventData = getEventData(sourceEvent, true, true);
        if (useEventData == null) return;

        var player = useEventData.getPlayer();

        spawnLingeringPotionCloudEffect.execute(sourceEvent, player.getLocation(),
                new PotionEffect(PotionEffectType.SLOW, 35, 2),
                12,
                100,
                0
        );
    }

}
