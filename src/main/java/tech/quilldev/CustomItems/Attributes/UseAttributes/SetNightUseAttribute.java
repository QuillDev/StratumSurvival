package tech.quilldev.CustomItems.Attributes.UseAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItems.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import tech.quilldev.CustomItems.Effects.TimeSetEffect;

public class SetNightUseAttribute extends UseAttribute {

    TimeSetEffect timeSetEffect = new TimeSetEffect();

    public SetNightUseAttribute(NamespacedKey key) {
        super(key,
                Component.text("Daniel's Blessing").color(TextColor.color(0xCB8D)),
                0f,
                3600 * 20);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent, true, true);
        if (eventData == null) return;
        var player = eventData.getPlayer();

        timeSetEffect.execute(sourceEvent,player.getLocation(), 13000);
    }
}
