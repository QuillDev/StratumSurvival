package tech.quilldev.CustomItemsv2.Effects;

import org.bukkit.entity.LivingEntity;

public class WhisperEffect extends Effect {

    public void execute(LivingEntity entity) {
        entity.sendMessage("Whisper mf");
    }
}
