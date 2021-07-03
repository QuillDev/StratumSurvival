package moe.quill.stratumsurvival.Commands.Management;

import com.google.inject.Inject;
import moe.quill.stratumsurvival.Utils.PlayerHelpers.InventoryHelper;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public record TrinketsCommand(
        InventoryHelper inventoryHelper) implements CommandExecutor {

    @Inject
    public TrinketsCommand {
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player target;
        if (args.length == 0) {
            if (!(sender instanceof Player senderPlayer)) {
                sender.sendMessage("Only players can issue this command without a target");
                return true;
            }

            target = senderPlayer;

        } else {
            target = Bukkit.getPlayer(args[0]);

            //if the target is invalid return out
            if (target == null) {
                sender.sendMessage(String.format("Invalid Target. %s", args[0]));
                return true;
            }
        }

        final var trinkets = inventoryHelper.getTrinkets(target);

        //if the player has no trinkets tell the sender
        if (trinkets.isEmpty()) {
            sender.sendMessage("This player has no trinkets!");
            return true;
        }

        //Start constructing the message
        var component = Component.empty()
                .append(Component.text(String.format("%s's Trinkets", target.getName())))
                .append(Component.newline())
                .append(Component.text("======================="))
                .append(Component.newline());

        //Generate pretty display components for each item
        for (int idx = 0; idx < trinkets.size(); idx++) {
            final var trinket = trinkets.get(idx);
            final var displayComponent = inventoryHelper.getItemDisplay(trinket);

            component = component.append(displayComponent);

            //if we're not on the last idx then append a newline character
            if (idx < trinkets.size() - 1) {
                component = component.append(Component.newline());
            }
        }

        sender.sendMessage(component);
        return true;
    }
}
