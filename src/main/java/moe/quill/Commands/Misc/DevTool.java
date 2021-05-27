package moe.quill.Commands.Misc;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;


public class DevTool implements CommandExecutor, Listener {
    private final Plugin plugin;

    private final NamespacedKey lootChestKey;
    private final MaterialManager materialManager;

    public DevTool(MaterialManager materialManager, Plugin plugin) {
        this.plugin = plugin;
        this.lootChestKey = new NamespacedKey(plugin, "loot_chest_key");
        this.materialManager = materialManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;

        return true;
    }
}
