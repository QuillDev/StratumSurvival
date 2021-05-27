package moe.quill.Crafting.Items.Attributes.UseAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.Effects.TimeSetEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import moe.quill.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;

@SuppressWarnings("unused")
public class UseSetDayAttribute extends UseAttribute {

    TimeSetEffect timeSetEffect = new TimeSetEffect();

    public UseSetDayAttribute() {
        super(AttributeKey.USE_SET_DAY_ATTRIBUTE,
                Component.text("Daniel's Bane").color(TextColor.color(0x214A2A)),
                0f,
                3600 * 20);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent, true, true);
        if (eventData == null) return;
        var player = eventData.getPlayer();

        timeSetEffect.execute(player.getLocation(), 1000);
    }
}
