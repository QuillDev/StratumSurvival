package tech.quilldev.ItemAttributes.OnHitAttributes.ExternalEffect;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.ItemAttributes.OnHitAttributes.OnHitAttribute;

public class VampirismOnHitAttribute extends OnHitAttribute {

    final Component flavorText = Component.text("VAMPIRISM")
            .color(TextColor.color(0xFF513E));

    public VampirismOnHitAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDamageByEntityEvent event, float modifier) {
        if (modifier < rand.nextFloat()) return;
        if (!(event.getDamager() instanceof Player)) return;


        //Get the player
        final var player = ((Player) event.getDamager()).getPlayer();
        if (player == null) return;

        final var amount = Math.round(Math.max((event.getDamage() * .25), 1));
        final var amountText = Component.text(amount)
                .color(TextColor.color(0xFF513E))
                .append(Component.text("HP"));

        final var maxHP = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (maxHP == null) return;
        var hpToSet = player.getHealth() + amount;
        if ((player.getHealth() + amount) >= maxHP.getValue()) {
            hpToSet = maxHP.getValue();
        }
        ; //Make it so you can't overheal
        player.setHealth(hpToSet);
        player.sendMessage(
                Component.text("Your")
                        .append(Component.space())
                        .append(flavorText)
                        .append(Component.space())
                        .append(Component.text("healed you for"))
                        .append(Component.space())
                        .append(amountText)
                        .append(Component.text("!"))
        );
    }
}
