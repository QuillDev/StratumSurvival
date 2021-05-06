package tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BowWeaponAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

public class BowWeaponAttributeWhisper extends BowWeaponAttribute {
    public BowWeaponAttributeWhisper(NamespacedKey key) {
        super(key, Component.text("WHISPER AFAJIGFAOIJGJIOGOIJASGO"), 0);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
    }
}
