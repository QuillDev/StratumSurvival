package moe.quill.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.Effects.KnockbackEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

public class BluntWeaponHookAttribute extends BluntWeaponAttribute{

    public final static KnockbackEffect knockbackEffect = new KnockbackEffect();

    public BluntWeaponHookAttribute() {
        super(AttributeKey.BLUNT_WEAPON_HOOK_ATTRIBUTE,
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
