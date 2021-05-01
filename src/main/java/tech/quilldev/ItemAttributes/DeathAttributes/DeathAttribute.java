package tech.quilldev.ItemAttributes.DeathAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDeathEvent;
import tech.quilldev.ItemAttributes.Attribute;

public abstract class DeathAttribute extends Attribute {
    public DeathAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    public abstract void execute(EntityDeathEvent deathEvent);
}
