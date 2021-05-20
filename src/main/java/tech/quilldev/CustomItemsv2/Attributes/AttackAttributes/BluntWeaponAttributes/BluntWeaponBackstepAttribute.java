package tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItemsv2.Effects.KnockbackEffect;

public class BluntWeaponBackstepAttribute extends BluntWeaponAttribute{

    public final static KnockbackEffect knockbackEffect = new KnockbackEffect();

    public BluntWeaponBackstepAttribute(NamespacedKey key) {
        super(key,
                Component.text("Backstep").color(TextColor.color(0x4D1DCB)),
                0f,
                0f,
                0f
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;
        knockbackEffect.execute(eventData.getEvent(), .5f);
    }

}
