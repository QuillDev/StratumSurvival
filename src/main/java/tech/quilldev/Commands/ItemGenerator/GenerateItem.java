package tech.quilldev.Commands.ItemGenerator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.CustomItemsv2.ItemGenerator.ItemGenerator;

public class GenerateItem implements CommandExecutor {

    private final static ItemGenerator generator = new ItemGenerator();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //Make sure we can get a valid player
        if (!(sender instanceof Player)) return false;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return false;

        ItemStack item = null;
        if (args.length == 0) {
            item = generator.generateItem();
        }
        if (args.length == 1) {
            final var category = ItemAttributes.getWeaponCategory(args[0]);
            item = generator.generateItem(category);
        }

        if (item == null) return false; //if the item is null, return
        player.getInventory().addItem(item); //add the item to the inventory
        return false;
    }
}