package tech.quilldev.ItemAttributes.DamageAttribute.ExternalEffect;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageAttribute;

public class FireHitEffect extends DamageAttribute {
    public FireHitEffect(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDamageByEntityEvent event, float modifier) {
        if (modifier < rand.nextFloat()) return;

        event.getEntity().setFireTicks(60);

        final var flavorText = Component.text("BURNED").color(TextColor.color(0xFF1610));

        //send a message that you effected the opponent
        event.getDamager().sendMessage(
                Component.text("You")
                        .append(Component.space())
                        .append(flavorText)
                        .append(Component.space())
                        .append(Component.text("your opponent!"))
        );
    }
}
