package moe.quill.Commands.ItemCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import moe.quill.Crafting.CustomItems.ItemHelpers.ItemHelper;

public class ObfuscateItem implements CommandExecutor {
    private static final ItemHelper itemHelper = new ItemHelper();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        final var item = player.getInventory().getItemInMainHand();
        itemHelper.encryptItem(item);

        return true;
    }
}
