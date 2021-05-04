package tech.quilldev.CustomItemsV1.ItemAttributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;
import org.bukkit.event.entity.EntityDeathEvent;

public class RatOnDeathAttribute extends OnDeathAttribute {

    public RatOnDeathAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDeathEvent event) {
        final var entity = event.getEntity();
        //Spawn a rat at the location where the entity died
        var wolf = (Wolf) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.WOLF);

        final var killer = entity.getKiller();
        if (killer == null) return;
        wolf.setCustomName(killer.getName() + "'s Rat");
        wolf.setCustomNameVisible(false);
        wolf.setOwner(killer);
        wolf.setTamed(true);
        wolf.setSitting(false);
        wolf.setAI(true);
    }
}
