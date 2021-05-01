package tech.quilldev.ItemAttributes.DamageAttribute.DamageModifier;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageAttribute;

public class BonusDamageAttribute extends DamageAttribute {
    public BonusDamageAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDamageByEntityEvent event, float modifier) {
        System.out.println("Tried to use damage modifier");
        event.setDamage(event.getDamage() * (1 + modifier));
    }
}
