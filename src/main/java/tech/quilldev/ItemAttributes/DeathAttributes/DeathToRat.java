package tech.quilldev.ItemAttributes.DeathAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeathToRat extends DeathAttribute {

    public DeathToRat(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDeathEvent event) {
        //Spawn a rat at the location where the entity died
        var chicken = (Chicken) event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.CHICKEN);
        chicken.setCustomName("rat");
        chicken.setCustomNameVisible(false);
        chicken.setBaby();
        chicken.setAI(true);
    }
}
