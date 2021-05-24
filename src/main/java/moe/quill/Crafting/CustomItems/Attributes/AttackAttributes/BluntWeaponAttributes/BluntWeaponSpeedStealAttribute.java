package moe.quill.Crafting.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.CustomItems.Effects.EffectHelpers.EffectHelper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffectType;
import moe.quill.Crafting.CustomItems.Effects.PotionBasedEffect;

public class BluntWeaponSpeedStealAttribute extends BluntWeaponAttribute {

    public static PotionBasedEffect potionBasedEffect = new PotionBasedEffect();

    EffectHelper helper = new EffectHelper();

    public BluntWeaponSpeedStealAttribute(NamespacedKey key) {
        super(key,
                Component.text("Speed Leach").color(TextColor.color(0x1C6FF7)),
                0,
                0,
                0
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var event = getEventData(sourceEvent);
        if (event == null) return;

        potionBasedEffect.execute(sourceEvent, PotionEffectType.SPEED, event.getPlayer(), 25);
        potionBasedEffect.execute(sourceEvent, PotionEffectType.SLOW, event.getTarget(), 25);
    }
}
