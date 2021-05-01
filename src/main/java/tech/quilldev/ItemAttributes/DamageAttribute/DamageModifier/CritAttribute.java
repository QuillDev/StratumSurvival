package tech.quilldev.ItemAttributes.DamageAttribute.DamageModifier;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageAttribute;

import java.util.Random;

public class CritAttribute extends DamageAttribute {

    //Critical text component
    private final Component critText = Component.text("CRITICALY STRUCK")
            .color(TextColor.color(0x832C24));

    public CritAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDamageByEntityEvent event, float modifier) {
        if (!(event.getDamager() instanceof Player)) return;

        final var player = ((Player) event.getDamager()).getPlayer();
        if (player == null) return;

        if (rand.nextFloat() > modifier) return; //check if we got a critical roll
        event.setDamage(event.getDamage() * 2);
        player.sendMessage(
                Component.text("You")
                        .append(Component.space())
                        .append(critText)
                        .append(Component.space())
                        .append(Component.text("your opponent."))
        );
    }
}
