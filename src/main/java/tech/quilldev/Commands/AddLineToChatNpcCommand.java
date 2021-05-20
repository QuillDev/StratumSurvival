package tech.quilldev.Commands;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.NPCManager.ChatNPC.ChatNPCManager;

import java.util.Arrays;

public class AddLineToChatNpcCommand implements CommandExecutor {

    private final ChatNPCManager chatNPCManager;

    public AddLineToChatNpcCommand(ChatNPCManager chatNPCManager) {
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
