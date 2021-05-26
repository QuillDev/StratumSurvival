package moe.quill.Events.ToolEvents;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.persistence.PersistentDataType;

public class GrappleHookEvent implements Listener {

    private final NamespacedKey grappleKey;

    public GrappleHookEvent(StratumMaterialManager materialManager) {
        this.grappleKey = materialManager.getNamespacedMaterialKey(MaterialKey.GRAPPLING_HOOK_KEY);
    }

    @EventHandler
    public void onUseHook(PlayerFishEvent event) {
        final var state = event.getState();
        final var hook = event.getHook();
        final var player = event.getPlayer();
        final var heldItem = player.getInventory().getItemInMainHand();
        final var heldItemMeta = heldItem.getItemMeta();
        final var itemData = heldItemMeta.getPersistentDataContainer();
        if (!itemData.has(grappleKey, PersistentDataType.BYTE_ARRAY)) return;
        if (!state.equals(PlayerFishEvent.State.REEL_IN)) return;

        //Say that can't fish with a grappling hook
        if (event.getCaught() != null) {
            player.sendMessage("You can't fish with a grappling hook.. How would that work?");
            event.setCancelled(true);
            return;
        }
        //Location of the fishing hook
        final var hookLocation = hook.getLocation();

        //Calculate the direction to set the player to
        final var direction =
                hookLocation
                        .subtract(player.getLocation()) //Get the direction
                        .toVector() //Convert it to a vector
                        .normalize() //Normalize it
                        .multiply(3); //Set the magnitude to 3
        player.setVelocity(direction);
    }
}
