package tech.quilldev.NPCManager.NPCEvents;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import tech.quilldev.CustomItems.Attributes.ItemAttributes;
import tech.quilldev.CustomItems.ItemHelpers.ItemHelper;
import tech.quilldev.NPCManager.NPCManager;
import tech.quilldev.NPCManager.NPCs.NPCType;
import tech.quilldev.PlayerHelpers.PlayerInventoryHelper;
import tech.quilldev.Serialization.StratumSerialization;

public class InteractBlacksmithEvent implements Listener {

    private final NamespacedKey blacksmithKey;
    private final ItemHelper itemHelper = new ItemHelper();
    private final PlayerInventoryHelper inventoryHelper = new PlayerInventoryHelper();
    private final StratumMaterialManager materialManager;

    public InteractBlacksmithEvent(NPCManager npcManager, StratumMaterialManager materialManager) {
        this.blacksmithKey = npcManager.getNPCByType(NPCType.BLACKSMITH).getKey();
        this.materialManager = materialManager;
    }

    @EventHandler
    public void reRollHeldItemEvent(PlayerInteractEntityEvent event) {
        final var entity = event.getRightClicked();
        if (!(entity instanceof Villager)) return;
        final var player = event.getPlayer();
        final var heldItem = player.getInventory().getItemInMainHand();

        //Make sure that the target we're interacting with is a cryptologist
        final var entityData = entity.getPersistentDataContainer();
        if (!(entityData.has(blacksmithKey, PersistentDataType.BYTE_ARRAY))) return;
        event.setCancelled(true); //cancel interactions if this is a special villages

        //Make sure that the item is obfuscated
        final var meta = heldItem.getItemMeta();
        if (meta == null) return;
        final var itemData = meta.getPersistentDataContainer();
        if (itemData.has(ItemAttributes.obfuscatedKey, PersistentDataType.BYTE_ARRAY)) return;
        if (!itemData.has(ItemAttributes.levelKey, PersistentDataType.BYTE_ARRAY)) return;
        final var levelBytes = itemData.get(ItemAttributes.levelKey, PersistentDataType.BYTE_ARRAY);
        var level = (int) StratumSerialization.deserializeFloat(levelBytes);

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
