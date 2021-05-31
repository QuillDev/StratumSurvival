package moe.quill.Commands.ItemCommands;

import moe.quill.Crafting.Items.ItemHelpers.ItemHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DeobfuscateItem implements CommandExecutor {
    private final ItemHelper itemHelper;

    public DeobfuscateItem(ItemHelper itemHelper) {
        this.itemHelper = itemHelper;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        final var item = player.getInventory().getItemInMainHand();
        itemHelper.decryptItem(item);
        return true;
    }
}
