package tech.quilldev.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.CustomItemsv2.ItemGenerator.ItemGenerator;

public class RerollItem implements CommandExecutor {

    private static final ItemGenerator generator = new ItemGenerator();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;

        final var heldItem = player.getInventory().getItemInMainHand();
        generator.rerollItem(heldItem);
        return false;
    }
}
