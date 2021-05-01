package tech.quilldev.ItemAttributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDeathEvent;
import tech.quilldev.ItemAttributes.Attribute;

public abstract class OnDeathAttribute extends Attribute {
    public OnDeathAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    public abstract void execute(EntityDeathEvent deathEvent);
}
