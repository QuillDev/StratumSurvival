package tech.quilldev.CustomItemsv2.Effects;

import org.bukkit.event.Event;

public class WhisperEffect extends Effect {

    public void execute(Event event) {
        final var target = helper.getLivingEntity(event);
        target.sendMessage("Whisper mf");
    }
}