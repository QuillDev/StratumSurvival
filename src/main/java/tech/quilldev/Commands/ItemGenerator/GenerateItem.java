package tech.quilldev.Commands.ItemGenerator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.CustomItems.Attributes.ItemAttributes;
import tech.quilldev.CustomItems.ItemHelpers.ItemGenerator;

public class GenerateItem implements CommandExecutor {

    private final ItemGenerator itemGenerator;

    public GenerateItem(ItemGenerator itemGenerator) {
        this.itemGenerator = itemGenerator;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //Make sure we can get a valid player
        if (!(sender instanceof Player)) return false;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return false;

        ItemStack item = null;
        if (args.length == 0) {
            item = itemGenerator.generateItem();
        }
        if (args.length == 1) {
            final var category = ItemAttributes.getWeaponCategory(args[0]);
            item = itemGenerator.generateItem(category);
        }

        if (args.length == 2) {
            final var category = ItemAttributes.getWeaponCategory(args[0]);
            int itemCount;
            try {
                itemCount = Integer.parseInt(args[1]);
            } catch (NumberFormatException exception) {
                return false;
            }

            itemCount = (itemCount == 0 ? 1 : itemCount);
            for (int i = 0; i < itemCount || i == 35; i++) {
                item = itemGenerator.generateItem(category);
                player.getInventory().addItem(item);
            }
            item = null;
        }

        if (item == null) return false; //if the item is null, return
        player.getInventory().addItem(item); //add the item to the inventory
        return false;
    }
}
