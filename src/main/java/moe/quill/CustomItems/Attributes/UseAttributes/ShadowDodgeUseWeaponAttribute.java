package moe.quill.CustomItems.Attributes.UseAttributes;

import moe.quill.CustomItems.Effects.CloakEffect;
import moe.quill.CustomItems.Effects.KnockbackEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import moe.quill.CustomItems.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;

public class ShadowDodgeUseWeaponAttribute extends UseAttribute {

    public final static CloakEffect cloakEffect = new CloakEffect();
    public final static KnockbackEffect knockbackEffect = new KnockbackEffect();

    public ShadowDodgeUseWeaponAttribute(NamespacedKey key) {
        super(key,
                Component.text("Shadow Dodge").color(TextColor.color(0x3F0BCB)),
                0f,
                100L);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var useEventData = getEventData(sourceEvent, true, true);
        if (useEventData == null) return;

        var player = useEventData.getPlayer();

        knockbackEffect.execute(useEventData.getEvent(), player,.5f);
        cloakEffect.execute(useEventData.getEvent(), 15);
    }

}
