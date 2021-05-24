package moe.quill.Crafting.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.CustomItems.Effects.KnockbackEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

public class BluntWeaponFeintAttribute extends BluntWeaponAttribute{

    public final static KnockbackEffect knockbackEffect = new KnockbackEffect();

    public BluntWeaponFeintAttribute(NamespacedKey key) {
        super(key,
                Component.text("Feint").color(TextColor.color(0x4D1DCB)),
                0f,
                0f,
                0f
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;

        var player = eventData.getPlayer();

        knockbackEffect.execute(eventData.getEvent(), player, .5f);
    }

}
