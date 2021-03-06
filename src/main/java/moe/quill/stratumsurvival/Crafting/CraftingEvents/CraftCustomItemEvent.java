package moe.quill.stratumsurvival.Crafting.CraftingEvents;

import com.google.inject.Inject;
import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.stratumsurvival.Crafting.Items.ItemHelpers.ItemGenerator;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Utils.PlayerHelpers.InventoryHelper;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.persistence.PersistentDataType;


public class CraftCustomItemEvent implements Listener {

    private final ItemGenerator generator;
    private final MaterialManager materialManager;
    private final InventoryHelper inventoryHelper;

    private final NamespacedKey shardKey;

    @Inject
    public CraftCustomItemEvent(IKeyManager keyManager, ItemGenerator generator, MaterialManager materialManager, InventoryHelper inventoryHelper) {
        this.generator = generator;
        this.materialManager = materialManager;
        this.shardKey = keyManager.getKey(MaterialKey.SHARD_KEY);
        this.inventoryHelper = inventoryHelper;
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

        //Get items from the crafting grid
        final var gridItems = inventoryHelper.getItemsFromMatrix(event.getInventory());

        //Get the first viewer (player)
        final var player = event.getView().getPlayer();
        //Get the crystal
        final var shard = gridItems.stream()
                .filter(itm -> itm.getItemMeta().getPersistentDataContainer().has(shardKey, PersistentDataType.BYTE_ARRAY))
                .findFirst().orElse(null);
        final var item = gridItems.stream()
                .filter(itm -> !itm.getItemMeta().getPersistentDataContainer().has(shardKey, PersistentDataType.BYTE_ARRAY))
                .findFirst().orElse(null);

        //If the crystal is null, cancel the event
        if (shard == null || item == null) {
            player.sendMessage("Failed to craft! Please report this error to a server administrator!");
            event.setCancelled(true);
            return;
        }

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
        player.getInventory().addItem(shard);
        player.getInventory().addItem(item);
        event.setCancelled(true);
    }
}
