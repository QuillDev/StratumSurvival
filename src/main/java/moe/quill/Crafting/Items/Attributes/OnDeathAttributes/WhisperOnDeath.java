package moe.quill.Crafting.Items.Attributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

public class WhisperOnDeath extends OnDeathAttribute {
    public WhisperOnDeath(NamespacedKey key) {
        super(
                key,
                Component.text("Whispering"),
                0f,
                0f,
                0f
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var data = getEventData(sourceEvent);
        if (data == null) return;
        data.getPlayer().sendMessage("Fuckin ell bruv that's fukin wikid m8");
    }
}
