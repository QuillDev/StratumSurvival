package tech.quilldev.NPCManager.NPCEvents;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.CustomItemsv2.ItemHelpers.ItemHelper;
import tech.quilldev.NPCManager.NPCManager;
import tech.quilldev.NPCManager.NPCs.NPCType;
import tech.quilldev.PlayerHelpers.PlayerInventoryHelper;

public class InteractCryptologistEvent implements Listener {

    private final NamespacedKey cryptoKey;
    private final ItemHelper itemHelper = new ItemHelper();
    private final PlayerInventoryHelper inventoryHelper = new PlayerInventoryHelper();

    public InteractCryptologistEvent(NPCManager npcManager) {
        this.cryptoKey = npcManager.getNPCByType(NPCType.CRYPTOLOGIST).getKey();
    }

    @EventHandler
    public void decryptHeldItemEvent(PlayerInteractEntityEvent event) {
        final var entity = event.getRightClicked();
        if (!(entity instanceof Villager)) return;
        final var player = event.getPlayer();
        final var heldItem = player.getInventory().getItemInMainHand();

        //Make sure that the target we're interacting with is a cryptologist
        final var entityData = entity.getPersistentDataContainer();
        if (!(entityData.has(cryptoKey, PersistentDataType.BYTE_ARRAY))) return;
        event.setCancelled(true); //cancel interactions if this is a special villages


        //Make sure that the item is obfuscated
        final var meta = heldItem.getItemMeta();
        if (meta == null) return;
        final var itemData = meta.getPersistentDataContainer();
        if (!itemData.has(ItemAttributes.obfuscatedKey, PersistentDataType.BYTE_ARRAY)) return;
        itemHelper.decryptItem(heldItem);
        player.sendMessage(
                Component.text("The cryptologist studies your item and finds")
                        .append(Component.space())
                        .append(inventoryHelper.getItemDisplay(heldItem))
        );

    }

}
