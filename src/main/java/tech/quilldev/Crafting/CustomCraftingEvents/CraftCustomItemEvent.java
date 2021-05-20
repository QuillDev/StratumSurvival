package tech.quilldev.Crafting.CustomCraftingEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.MaterialKey;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import tech.quilldev.CustomItems.ItemHelpers.ItemGenerator;


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
        ItemStack shard = null;
        for (final var slotItem : slots) {
            if (slotItem == null) continue;
            final var slotMeta = slotItem.getItemMeta();
            final var data = slotMeta.getPersistentDataContainer();
            if (data.has(materialManager.getNamespacedMaterialKey(MaterialKey.SHARD_KEY), PersistentDataType.FLOAT)) {
                shard = slotItem;
                continue;
            }
            item = slotItem;
        }


        if (item == null) return;
        if (shard == null) return;
        //Set the item to have the same properties as the rolled item
        final var level = geodeMeta.getCustomModelData();
        final var rolledItem = generator.generateItem(item, level);

        //TODO: See if there's a "more organic" way to do this
        shard.setAmount(shard.getAmount() - 1);
        item.setItemMeta(rolledItem.getItemMeta());
        if (rolledItem.getItemMeta().hasCustomModelData()) {
            item.getItemMeta().setCustomModelData(rolledItem.getItemMeta().getCustomModelData());
        }

        event.getInventory().clear();
        event.getInventory().getViewers().get(0).getInventory().addItem(shard);
        event.getInventory().getViewers().get(0).getInventory().addItem(item);
        event.setCancelled(true);
    }
}
