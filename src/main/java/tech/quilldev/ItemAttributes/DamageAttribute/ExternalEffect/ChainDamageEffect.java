package tech.quilldev.ItemAttributes.DamageAttribute.ExternalEffect;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.w3c.dom.Text;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageAttribute;

import java.util.stream.Collectors;

public class ChainDamageEffect extends DamageAttribute {
    public ChainDamageEffect(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDamageByEntityEvent event, float modifier) {
        if (!(event.getDamager() instanceof Player)) return;
        if (modifier < rand.nextFloat()) return;

        //Get the player and the target entity
        final var player = ((Player) event.getDamager()).getPlayer();
        if (player == null) return;
        final var entity = event.getEntity();

        //Get valid targets
        final var targets = entity
                .getNearbyEntities(5, 5, 5)
                .stream()
                .filter(target -> (target instanceof Damageable))
                .map(target -> (Damageable) target)
                .collect(Collectors.toList());

        if (targets.size() <= 0) return; //make sure there are targets to chain
        final var damage = Math.round(Math.max(event.getDamage() * .25f, 2));
        targets.forEach((target) -> target.damage(damage));

        player.sendMessage(
                Component.text("You chained")
                        .append(Component.space())
                        .append(Component.text(targets.size()))
                        .append(Component.space())
                        .append(Component.text("for"))
                        .append(Component.space())
                        .append(Component.text(damage))
                        .append(Component.space())
                        .append(Component.text("!"))
        );
    }
}