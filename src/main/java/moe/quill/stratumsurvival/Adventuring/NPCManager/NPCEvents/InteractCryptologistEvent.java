package moe.quill.stratumsurvival.Adventuring.NPCManager.NPCEvents;

import moe.quill.stratumsurvival.Adventuring.NPCManager.NPCManager;
import moe.quill.stratumsurvival.Adventuring.NPCManager.NPCs.NPCType;
import moe.quill.stratumsurvival.Crafting.GlobalKey;
import moe.quill.stratumsurvival.Crafting.Items.ItemHelpers.ItemHelper;
import moe.quill.stratumsurvival.Crafting.KeyManager;
import moe.quill.stratumsurvival.Utils.PlayerHelpers.InventoryHelper;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataType;

public class InteractCryptologistEvent implements Listener {

    private final NamespacedKey cryptoKey;
    private final InventoryHelper inventoryHelper = new InventoryHelper();
    private final ItemHelper itemHelper;
    private final NamespacedKey obfuscatedKey;

    public InteractCryptologistEvent(KeyManager keyManager, ItemHelper itemHelper, NPCManager npcManager) {
        this.cryptoKey = npcManager.getNPCByType(NPCType.CRYPTOLOGIST).getKey();
        this.obfuscatedKey = keyManager.getNsKey(GlobalKey.OBFUSCATED_KEY);
        this.itemHelper = itemHelper;
    }

    //TODO: Redo item decryption
    @EventHandler
    public void decryptHeldItemEvent(PlayerInteractEntityEvent event) {
        if (!event.getHand().equals(EquipmentSlot.HAND)) return;
        final var entity = event.getRightClicked();
        //Make sure that the target we're interacting with is a cryptologist
        final var entityData = entity.getPersistentDataContainer();
        if (!(entityData.has(cryptoKey, PersistentDataType.BYTE_ARRAY))) return;
        final var player = event.getPlayer();
        final var heldItem = player.getInventory().getItemInMainHand();


        event.setCancelled(true); //cancel interactions if this is a special villages


        //Make sure that the item is obfuscated
        final var meta = heldItem.getItemMeta();
        if (meta == null) return;
        final var itemData = meta.getPersistentDataContainer();
        if (!itemData.has(obfuscatedKey, PersistentDataType.BYTE_ARRAY)) return;
        itemHelper.decryptItem(heldItem);
        player.sendMessage(
                Component.text("The cryptologist studies your item and finds")
                        .append(Component.space())
                        .append(inventoryHelper.getItemDisplay(heldItem))
        );

    }

}
