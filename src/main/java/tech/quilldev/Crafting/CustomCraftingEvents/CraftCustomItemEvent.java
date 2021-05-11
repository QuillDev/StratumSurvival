package tech.quilldev.Crafting.CustomCraftingEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import tech.quilldev.Crafting.StratumMaterialManager;
import tech.quilldev.CustomItemsv2.ItemHelpers.ItemGenerator;


public class CraftCustomItemEvent implements Listener {

    private final ItemGenerator generator;
    private final StratumMaterialManager materialManager;

    public CraftCustomItemEvent(ItemGenerator generator, StratumMaterialManager materialManager) {
        this.generator = generator;
        this.materialManager = materialManager;

    }

    @EventHandler
    public void onCraftGeodeEvent(CraftItemEvent event) {
        final var result = event.getRecipe().getResult();
        final var craftSlotItem = event.getCurrentItem(); //The item that is being outputted
        if (craftSlotItem == null) return;

        final var geodeMatch = materialManager.getGeodeMaterials()
                .stream()
                .filter(geode -> geode.equals(result))
                .findFirst()
                .orElse(null);

        if (geodeMatch == null) return;

        final var geodeMeta = geodeMatch.getItemMeta();
        if (!geodeMeta.hasCustomModelData()) return; //TODO: HACKY IF THIS BREAKS< YOU KNOW WHY
        final var slots = event.getInventory().getMatrix();

        ItemStack item = null;
        ItemStack crystal = null;
        for (final var slotItem : slots) {
            if (slotItem == null) continue;
            final var slotMeta = slotItem.getItemMeta();
            final var data = slotMeta.getPersistentDataContainer();
            if (data.getKeys().size() > 0) {
                crystal = slotItem;
                continue;
            }
            item = slotItem;
        }


        if (item == null) return;
        if (crystal == null) return;
        //Set the item to have the same properties as the rolled item
        final var level = geodeMeta.getCustomModelData();
        final var rolledItem = generator.generateItem(item, level); //TODO: Make the item match the original one
//        craftSlotItem.setType(item.getType());
//        if (item.getItemMeta().hasCustomModelData()) {
//
//            craftSlotItem.getItemMeta().setCustomModelData(item.getItemMeta().getCustomModelData());
//        }

        //TODO: BUG, WHY
//        craftSlotItem.setItemMeta(rolledItem.getItemMeta());
        crystal.setAmount(crystal.getAmount() - 1);
        item.setItemMeta(rolledItem.getItemMeta());
        if (rolledItem.getItemMeta().hasCustomModelData()) {
            item.getItemMeta().setCustomModelData(rolledItem.getItemMeta().getCustomModelData());
        }

        event.getInventory().clear();
        event.getInventory().getViewers().get(0).getInventory().addItem(crystal);
        event.getInventory().getViewers().get(0).getInventory().addItem(item);
        event.setCancelled(true);
    }
}
