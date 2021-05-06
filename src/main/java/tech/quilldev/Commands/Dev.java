package tech.quilldev.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.Crafting.CraftItem;

public class Dev implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;

        ((Player) sender).getInventory().addItem(CraftItem.SHARD_COMMON);
        return true;
    }
}
