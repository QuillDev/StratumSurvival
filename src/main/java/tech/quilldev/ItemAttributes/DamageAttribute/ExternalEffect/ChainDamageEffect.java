package tech.quilldev.ItemAttributes.DamageAttribute.ExternalEffect;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.w3c.dom.Text;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageAttribute;

public class ChainDamageEffect extends DamageAttribute {
    public ChainDamageEffect(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDamageByEntityEvent event, float modifier) {
        if(rand.nextFloat() > modifier) return;

        var entityList = event.getEntity().getNearbyEntities(10,10,10);
        final var size = Component.text(entityList.size());
        final var flavorText = Component.text("Chained").color(TextColor.color(0xFF1610));

        for ( Entity entity : entityList) {
            if (!(entity instanceof Mob)) return;

            ((Mob) entity).damage(event.getDamage());
        }

        //send a message that you effected the opponent
        event.getDamager().sendMessage(
                Component.text("You")
                        .append(Component.space())
                        .append(flavorText)
                        .append(Component.space())
                        .append(Component.text("damage to ")
                        .append(size)
                        .append(Component.text( " Enemies!"))
                        )
        );
    }
}
