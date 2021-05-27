package moe.quill.Events.ToolEvents;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Utils.ItemGroups;
import moe.quill.Utils.Particles.ParticleFactory;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashSet;

public class IcePickClimb implements Listener {

    private final NamespacedKey icepickKey;
    private final ParticleFactory particleFactory = new ParticleFactory();


    public IcePickClimb(MaterialManager materialManager) {
        this.icepickKey = materialManager.getNamespacedMaterialKey(MaterialKey.ICEPICK_KEY);
    }

    //Enable Climbing using ice picks
    @EventHandler
    public void climbUsingIcePick(PlayerMoveEvent event) {
        final var player = event.getPlayer();
        final var location = player.getLocation();
        final var direction = location.getDirection();
        if (direction.getY() < .6) return; //If the player is not looking up, return
        final var heldItem = player.getInventory().getItemInMainHand();
        if (!heldItem.hasItemMeta()) return;
        final var itemMeta = heldItem.getItemMeta();
        final var data = itemMeta.getPersistentDataContainer();
        if (data.getKeys().size() == 0) return;
        if (!data.has(icepickKey, PersistentDataType.BYTE_ARRAY)) return;
        if (!isCardinal(player.getFacing())) return;
        final var blockInFront = location.getBlock().getRelative(player.getFacing());

        if (!containsBlockOfType(blockInFront, ItemGroups.Ice)) return;
        final var geom = particleFactory.createHitboxGeometry(blockInFront.getBoundingBox(), player.getLocation().getWorld());
        particleFactory.constructParticleGeometry(geom, Color.FUCHSIA, player.getWorld());
        player.setVelocity(player.getVelocity().setY(direction.getY() / 4f));
    }

    private boolean isCardinal(BlockFace facing) {
        return switch (facing) {
            case NORTH, SOUTH, EAST, WEST, NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST -> true;
            default -> false;
        };
    }

    private boolean containsBlockOfType(Block block, HashSet<Material> materials) {
        return materials.contains(block.getType());
    }
}
