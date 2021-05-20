package tech.quilldev.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.NPCManager.ChatNPC.ChatNPCManager;

public class SpawnChatNPC implements CommandExecutor {

    final ChatNPCManager chatNPCManager;

    public SpawnChatNPC(ChatNPCManager chatNPCManager) {
        this.chatNPCManager = chatNPCManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1) return true;
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        final var location = player.getLocation();
        this.chatNPCManager.spawnNPC(args[0], location);
        return false;
    }
}
