package tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.CustomItemsv2.Effects.WhisperEffect;

public class BluntWeaponWhisperAttribute extends BluntWeaponAttribute {

    private static final WhisperEffect whisper = new WhisperEffect();

    public BluntWeaponWhisperAttribute(NamespacedKey key) {
        super(key, Component.text("test"));
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        if (!(sourceEvent instanceof EntityDamageByEntityEvent)) return;
        final var event = (EntityDamageByEntityEvent) sourceEvent;
        final var msgTarget = (LivingEntity) event.getDamager();
        whisper.execute(msgTarget);

    }
}
