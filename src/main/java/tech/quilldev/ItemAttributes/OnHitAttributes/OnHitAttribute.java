package tech.quilldev.ItemAttributes.OnHitAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.ItemAttributes.Attribute;

public abstract class OnHitAttribute extends Attribute {
    public OnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    public abstract void execute(EntityDamageByEntityEvent event, float modifier);
}
