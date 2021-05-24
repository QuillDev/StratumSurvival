package moe.quill.Crafting.CustomItems.Attributes.UseAttributes;

import moe.quill.Crafting.CustomItems.Effects.SpawnLingeringPotionCloudEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import moe.quill.Crafting.CustomItems.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;

public class JumpBoostUseWeaponAttribute extends UseAttribute {
    SpawnLingeringPotionCloudEffect spawnLingeringPotionCloudEffect = new SpawnLingeringPotionCloudEffect();

    public JumpBoostUseWeaponAttribute(NamespacedKey key) {
        super(key,
                Component.text("Acrobatic Field").color(TextColor.color(0x53CB35)),
                0f,
                500L);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var useEventData = getEventData(sourceEvent, true, true);
        if (useEventData == null) return;

        var player = useEventData.getPlayer();

        spawnLingeringPotionCloudEffect.execute(sourceEvent,player.getLocation(),
                new PotionEffect(PotionEffectType.JUMP,100,5),
                3,
                120,
                0
        );
        spawnLingeringPotionCloudEffect.execute(sourceEvent,player.getLocation(),
                new PotionEffect(PotionEffectType.SLOW_FALLING,100,1),
                3,
                120,
                0
        );
    }

}
