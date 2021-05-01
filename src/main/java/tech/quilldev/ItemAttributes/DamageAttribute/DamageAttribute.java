package tech.quilldev.ItemAttributes.DamageAttribute;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.ItemAttributes.Attribute;

public abstract class DamageAttribute extends Attribute {
    public DamageAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    public abstract void execute(EntityDamageByEntityEvent event, float modifier);
}
