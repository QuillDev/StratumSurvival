package moe.quill.stratumsurvival.Commands.NPCCommands.ChatNPCCommands.AddChatLines;

import moe.quill.stratumsurvival.Adventuring.NPCManager.ChatNPC.ChatNPCManager;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class AddChatLineCommand implements CommandExecutor {

    private final ChatNPCManager chatNPCManager;

    public AddChatLineCommand(ChatNPCManager chatNPCManager) {
        this.chatNPCManager = chatNPCManager;
    }

    //TODO: Write lines on villagers as bytes so they persist.
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 2) return true;
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        final var messageArray = Arrays.copyOfRange(args, 1, args.length);
        chatNPCManager.addLineFromName(args[0], Component.text(String.join(" ", messageArray)));
        return true;
    }
}
