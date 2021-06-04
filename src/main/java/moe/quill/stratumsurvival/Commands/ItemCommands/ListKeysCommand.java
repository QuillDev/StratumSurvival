package moe.quill.stratumsurvival.Commands.ItemCommands;

import moe.quill.stratumsurvival.Commands.PlayerCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ListKeysCommand implements CommandExecutor, PlayerCommand {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final var player = getPlayerFromSender(sender);
        if (player == null) return true;
        final var heldItem = player.getInventory().getItemInMainHand();

        //If it has no meta, just exit
        if (!heldItem.hasItemMeta()) {
            player.sendMessage("This item has no meta!");
            return true;
        }

        final var itemMeta = heldItem.getItemMeta();
        final var itemData = itemMeta.getPersistentDataContainer();

        //if the item has no keys just exit out
        if (itemData.getKeys().size() == 0) {
            player.sendMessage("This item has no keys!");
            return true;
        }

        player.sendMessage(String.format("Found %s keys!", itemData.getKeys().size()));
        itemData.getKeys().forEach(key -> {
            player.sendMessage(key.getKey());
        });

        return true;
    }
}
