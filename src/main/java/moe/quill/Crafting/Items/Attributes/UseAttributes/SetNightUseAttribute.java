package moe.quill.Crafting.Items.Attributes.UseAttributes;

import moe.quill.Crafting.Items.Effects.TimeSetEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import moe.quill.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;

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

        timeSetEffect.execute(player.getLocation(), 13000);
    }
}
