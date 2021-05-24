package moe.quill.Commands.Misc;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Adventuring.Enemies.EnemyManager;
import moe.quill.Adventuring.Enemies.EnemyType;
import moe.quill.Adventuring.Enemies.StrayBased.WeebEnemy;
import moe.quill.Adventuring.Enemies.ZombieBased.PirateEnemy;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class DevTool implements CommandExecutor, Listener {
    private final Plugin plugin;

    private final NamespacedKey lootChestKey;
    private final StratumMaterialManager materialManager;

    public DevTool(StratumMaterialManager materialManager, Plugin plugin) {
        this.plugin = plugin;
        this.lootChestKey = new NamespacedKey(plugin, "loot_chest_key");
        this.materialManager = materialManager;

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;


        final var heavy_helmet = materialManager.getItem(StratumMaterial.HELMET_LEATHER_HEAVY);
        final var heavy_boots = materialManager.getItem(StratumMaterial.BOOTS_LEATHER_HEAVY);
        final var light_helmet = materialManager.getItem(StratumMaterial.HELMET_LEATHER_LIGHT);
        final var light_boots = materialManager.getItem(StratumMaterial.BOOTS_LEATHER_LIGHT);

        player.getInventory().addItem(light_boots);
        return true;
    }
}
