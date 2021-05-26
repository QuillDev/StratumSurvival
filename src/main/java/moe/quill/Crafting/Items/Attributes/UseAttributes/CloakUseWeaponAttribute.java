package moe.quill.Crafting.Items.Attributes.UseAttributes;

import moe.quill.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import moe.quill.Crafting.Items.Effects.CloakEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

public class CloakUseWeaponAttribute extends UseAttribute {

    private final static CloakEffect cloakEffect = new CloakEffect();

    public CloakUseWeaponAttribute(NamespacedKey key) {
        super(key,
                Component.text("Cloaking Mist").color(TextColor.color(0x3F0BCB)),
                0f,
                15 * 20);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent, true, true);
        if (eventData == null) return;
        cloakEffect.execute(eventData.getEvent(), 45);
    }
}
