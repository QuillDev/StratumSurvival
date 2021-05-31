package moe.quill.stratumsurvival.Commands.ItemCommands.GiveStratumItem;

import moe.quill.stratumsurvival.Commands.PlayerCommand;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GiveStratumItemCommand implements CommandExecutor, PlayerCommand {

    private final MaterialManager materialManager;

    public GiveStratumItemCommand(MaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final var player = getPlayerFromSender(sender);
        if (player == null) return true;


        //if they didn't specify an item let em know
        if (args.length == 0) {
            player.sendMessage("You did not specify an item");
            return true;
        }


        ItemStack itemToGive = materialManager.getItem(args[0]);
        if (itemToGive == null) {
            player.sendMessage("Could not find item with name " + args[0]);
            return true;
        }
        int amount = 1;
        if (args.length == 2) {
            final var newAmount = Integer.parseUnsignedInt(args[1]);
            if (!Double.isNaN(newAmount)) {
                amount = newAmount;
            }
        }

        //Set the qty of the item + give it
        itemToGive.setAmount(amount);
        player.getInventory().addItem(itemToGive);
        return true;
    }
}
