package moe.quill.Adventuring.NPCManager.NPCEvents;

import moe.quill.Adventuring.NPCManager.NPCManager;
import moe.quill.Adventuring.NPCManager.NPCs.NPCType;
import moe.quill.Crafting.GlobalKey;
import moe.quill.Crafting.Items.ItemHelpers.ItemHelper;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import moe.quill.StratumSurvival;
import moe.quill.Utils.PlayerHelpers.InventoryHelper;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataType;

public class InteractBlacksmithEvent implements Listener {

    //Instantiated Vars
    private final InventoryHelper inventoryHelper = new InventoryHelper();

    //Instanced Vars
    private final NamespacedKey blacksmithKey;
    private final MaterialManager materialManager;
    private final ItemHelper itemHelper;

    //Setup Keys we need
    private final NamespacedKey obfuscatedKey;
    private final NamespacedKey levelKey;

    public InteractBlacksmithEvent(NPCManager npcManager, MaterialManager materialManager, KeyManager keyManager, ItemHelper itemHelper) {
        this.blacksmithKey = npcManager.getNPCByType(NPCType.BLACKSMITH).getKey();
        this.materialManager = materialManager;
        this.itemHelper = itemHelper;

        this.obfuscatedKey = keyManager.getNsKey(GlobalKey.OBFUSCATED_KEY);
        this.levelKey = keyManager.getNsKey(GlobalKey.LEVEL_KEY);
    }

    @EventHandler
    public void reRollHeldItemEvent(PlayerInteractEntityEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        final var entity = event.getRightClicked();
        final var entityData = entity.getPersistentDataContainer();
        if (!(entityData.has(blacksmithKey, PersistentDataType.BYTE_ARRAY))) return;
        final var player = event.getPlayer();
        final var heldItem = player.getInventory().getItemInMainHand();

        //Make sure that the target we're interacting with is a cryptologist
        event.setCancelled(true); //cancel interactions if this is a special villages

        //Make sure that the item is obfuscated
        final var meta = heldItem.getItemMeta();
        if (meta == null) return;
        final var itemData = meta.getPersistentDataContainer();
        if (itemData.has(obfuscatedKey, PersistentDataType.BYTE_ARRAY)) return;
        if (!itemData.has(levelKey, PersistentDataType.BYTE_ARRAY)) return;
        final var levelBytes = itemData.get(levelKey, PersistentDataType.BYTE_ARRAY);
        var level = (int) StratumSurvival.serializer.deserializeFloat(levelBytes);

        // Get the corresponding item based on the level
        final var crystalItem = materialManager.getCrystalForLevel(level);
        final var inventory = player.getInventory();

        //Make sure they have the given item, then remove it from their inventory
        final var inventoryMatch = itemHelper.getFirstInventoryMatch(inventory, crystalItem);

        // If the
        if (inventoryMatch == null) {
            player.sendMessage(
                    Component.text("You require")
                            .append(Component.space())
                            .append(inventoryHelper.getItemDisplay(crystalItem))
                            .append(Component.space())
                            .append(Component.text("to re-roll this item!"))
            );
            return;
        }


        inventoryMatch.setAmount(inventoryMatch.getAmount() - 1); //Subtract the item that they consumed
        itemHelper.reRollItem(heldItem); //re roll the held item

        //Send that they re-rolled the item
        player.sendMessage(
                Component.text("You re-rolled your")
                        .append(Component.space())
                        .append(inventoryHelper.getItemDisplay(heldItem))
                        .append(Component.text("!"))
        );
    }

}
