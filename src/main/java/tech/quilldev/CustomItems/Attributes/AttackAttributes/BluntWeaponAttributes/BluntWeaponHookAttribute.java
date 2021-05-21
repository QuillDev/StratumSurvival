package tech.quilldev.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItems.Effects.KnockbackEffect;

public class BluntWeaponHookAttribute extends BluntWeaponAttribute{

    public final static KnockbackEffect knockbackEffect = new KnockbackEffect();

    public BluntWeaponHookAttribute(NamespacedKey key) {
        super(key,
                Component.text("Pulling Slash").color(TextColor.color(0x2BCBC6)),
                0f,
                0f,
                0f
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;

        var target = eventData.getTarget();

        knockbackEffect.execute(eventData.getEvent(), target, .7f);
    }
}
