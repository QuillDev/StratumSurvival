package tech.quilldev.Crafting.CustomCraftingEvents;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.SmithItemEvent;
import tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BluntWeaponAttributes.BluntWeaponAttribute;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.CustomItemsv2.ItemHelpers.ItemGenerator;
import tech.quilldev.CustomItemsv2.WeaponLists;
import tech.quilldev.CustomItemsv2.WeaponType;


public class SmithCustomItemEvent implements Listener {

    private final ItemGenerator generator;

public SmithCustomItemEvent(ItemGenerator generator){this.generator = generator;}

    @EventHandler
    public void onSmithItemEvent(SmithItemEvent event){

        final var item = event.getCurrentItem();
        final var itemMeta = item.getItemMeta();

        final var RolledName = generator.generateRandomItemName(item);
        itemMeta.displayName(RolledName);

        item.setItemMeta(itemMeta);
    }
}
