package moe.quill.Commands.ItemCommands;

import moe.quill.Crafting.Items.ItemHelpers.ItemHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RerollItem implements CommandExecutor {

//    private static final ItemHelper itemHelper = new ItemHelper();

    private final ItemHelper itemHelper;

    public RerollItem(ItemHelper itemHelper) {
        this.itemHelper = itemHelper;
    }

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
