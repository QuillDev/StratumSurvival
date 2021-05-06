package tech.quilldev.Commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Dev implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;

        var zeus = new ItemStack(Material.EMERALD);
        final var meta = zeus.getItemMeta();
        meta.setCustomModelData(2);
        zeus.setItemMeta(meta);
        ((Player) sender).getInventory().addItem(zeus);
        return true;
    }
}
