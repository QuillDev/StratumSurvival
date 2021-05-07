package tech.quilldev.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.CustomItemsv2.ItemHelpers.ItemHelper;

public class RerollItem implements CommandExecutor {

    private static final ItemHelper itemHelper = new ItemHelper();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;

        final var heldItem = player.getInventory().getItemInMainHand();
        itemHelper.reRollItem(heldItem);
        return false;
    }
}
