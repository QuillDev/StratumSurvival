package moe.quill.Commands;

import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Serialization.StratumSerialization;

public class DevTool implements CommandExecutor, Listener {

    private final StratumMaterialManager materialManager;
    private final Plugin plugin;
    private final NamespacedKey lootChestKey;

    public DevTool(StratumMaterialManager materialManager, Plugin plugin) {
        this.materialManager = materialManager;
        this.plugin = plugin;
        this.lootChestKey = new NamespacedKey(plugin, "loot_chest_key");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        
        final var head = materialManager.getItem(StratumMaterial.CHEST_LEGENDARY);
        final var location = player.getLocation();
        final var spawnLocation = new Location(location.getWorld(), location.getX(), location.getY() - 1.475, location.getZ());
        final var chestStand = (ArmorStand) player.getWorld().spawnEntity(spawnLocation, EntityType.ARMOR_STAND);
        final var chestStandData = chestStand.getPersistentDataContainer();
        chestStandData.set(lootChestKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
        chestStand.setAI(false);
        chestStand.setVisible(false);
        chestStand.setArms(false);
        chestStand.setItem(EquipmentSlot.HEAD, head);
        chestStand.setGravity(false);

        return true;
    }

    //Listen for opening chests
    @EventHandler
    public void openChestEvent(PlayerInteractAtEntityEvent event) {
        final var targetClicked = event.getRightClicked();
        if (!(targetClicked instanceof ArmorStand)) return;
        final var target = (ArmorStand) targetClicked;
        final var targetData = target.getPersistentDataContainer();
        if (!targetData.has(lootChestKey, PersistentDataType.BYTE_ARRAY)) return;
        event.setCancelled(true);
        final var player = event.getPlayer();
        player.sendMessage("Opened chest");
        targetClicked.remove();
    }
}
