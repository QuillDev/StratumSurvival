package tech.quilldev.CustomItemsv2.Attributes.UseAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import tech.quilldev.CustomItemsv2.Effects.CloakEffect;
import tech.quilldev.CustomItemsv2.Effects.KnockbackEffect;

public class ShadowDodgeUseWeaponAttribute extends UseAttribute {

    public final static CloakEffect cloakEffect = new CloakEffect();
    public final static KnockbackEffect knockbackEffect = new KnockbackEffect();

    public ShadowDodgeUseWeaponAttribute(NamespacedKey key) {
        super(key,
                Component.text("Shadow Dodge").color(TextColor.color(0x3F0BCB)),
                0f);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var useEventData = getEventData(sourceEvent, true, true);
        if (useEventData == null) return;
        knockbackEffect.execute(useEventData.getEvent(), 1.5f);
        cloakEffect.execute(useEventData.getEvent(), 15);
    }

}
