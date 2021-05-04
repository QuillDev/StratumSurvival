package tech.quilldev.CustomItemsV1.ItemAttributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class GoldOnDeathAttribute extends OnDeathAttribute {
    public GoldOnDeathAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDeathEvent deathEvent) {

        final var modifier = .3f;
        final var entity = deathEvent.getEntity();
        var item = new ItemStack(Material.GOLD_INGOT);

        if(modifier <= rand.nextFloat()) return;

        entity.getWorld().dropItemNaturally(entity.getLocation(), item);
    }
}
