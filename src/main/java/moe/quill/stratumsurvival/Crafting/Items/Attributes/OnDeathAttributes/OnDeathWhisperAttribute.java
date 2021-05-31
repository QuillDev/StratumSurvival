package moe.quill.stratumsurvival.Crafting.Items.Attributes.OnDeathAttributes;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;

public class OnDeathWhisperAttribute extends OnDeathAttribute {
    public OnDeathWhisperAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(
                materialManager,
                keyManager,
                AttributeKey.ON_DEATH_WHISPER_ATTRIBUTE,
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
