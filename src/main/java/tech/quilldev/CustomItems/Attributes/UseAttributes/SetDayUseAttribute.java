package tech.quilldev.CustomItems.Attributes.UseAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItems.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import tech.quilldev.CustomItems.Effects.TimeSetEffect;

public class SetDayUseAttribute extends UseAttribute {

    TimeSetEffect timeSetEffect = new TimeSetEffect();

    public SetDayUseAttribute(NamespacedKey key) {
        super(key,
                Component.text("Daniel's Bane").color(TextColor.color(0x214A2A)),
                0f,
                3600 * 20);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent, true, true);
        if (eventData == null) return;
        var player = eventData.getPlayer();

        timeSetEffect.execute(sourceEvent, player.getLocation(), 1000);
    }
}
