package tech.quilldev.ItemAttributes.DeathAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeathToRat extends DeathAttribute {

    public DeathToRat(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDeathEvent event) {

        final var entity = event.getEntity();
        //Spawn a rat at the location where the entity died
        var chicken = (Chicken) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.CHICKEN);
        var wolf = (Wolf) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.WOLF);

        final var killer = entity.getKiller();
        if (killer == null) return;
        chicken.setCustomName(killer.getName() + "'s Rat");
        chicken.setCustomNameVisible(false);
        chicken.setBaby();
        chicken.setAI(true);
    }
}
