package moe.quill.Crafting.CraftingEvents;

import moe.quill.Crafting.GlobalKey;
import moe.quill.Crafting.KeyManager;
import moe.quill.Utils.Serialization.StratumSerialization;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;

import java.util.Random;

public class GrindCustomWeaponEvent implements Listener {

    private final MaterialManager materialManager;

    //The level key
    private final NamespacedKey levelKey;

    public GrindCustomWeaponEvent(KeyManager keyManager, MaterialManager materialManager) {
        this.materialManager = materialManager;
        this.levelKey = keyManager.getNsKey(GlobalKey.LEVEL_KEY);

    }

    @EventHandler
    public void grindCustomItemEvent(PlayerInteractEvent event) {
        if (!(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) return;
        final var clickedBlock = event.getClickedBlock();
        if (clickedBlock == null) return;
        if (!clickedBlock.getType().equals(Material.GRINDSTONE)) return;
        final var heldItem = event.getItem();
        if (heldItem == null) return;
        final var meta = heldItem.getItemMeta();
        if (meta == null) return;

        //Get the level data from the data container
        final var data = meta.getPersistentDataContainer();
        if (data.getKeys().size() == 0) return;
        if (!data.has(levelKey, PersistentDataType.BYTE_ARRAY)) return;
        final var levelBytes = data.get(levelKey, PersistentDataType.BYTE_ARRAY);
        var level = (int) StratumSerialization.deserializeFloat(levelBytes);
        // Get the corresponding item based on the level
        final var item = materialManager.getFragmentForLevel(level);
        item.setAmount(2 + new Random().nextInt(3));
        final var inventory = event.getPlayer().getInventory();
        inventory.remove(heldItem);
        inventory.addItem(item);
        event.setCancelled(true); //cancel the event
    }
}
