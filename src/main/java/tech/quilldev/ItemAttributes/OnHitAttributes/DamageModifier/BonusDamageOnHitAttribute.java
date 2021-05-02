package tech.quilldev.ItemAttributes.OnHitAttributes.DamageModifier;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.ItemAttributes.OnHitAttributes.OnHitAttribute;

public class BonusDamageOnHitAttribute extends OnHitAttribute {
    public BonusDamageOnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDamageByEntityEvent event, float modifier) {
        event.setDamage(event.getDamage() * (1 + modifier));
    }
}
