package moe.quill.stratumsurvival.Commands.NPCCommands.ChatNPCCommands.DeleteChatNpc;

import moe.quill.stratumsurvival.Adventuring.NPCManager.ChatNPC.ChatNPCManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DeleteChatNpcCommand implements CommandExecutor {

    private final ChatNPCManager npcManager;

    public DeleteChatNpcCommand(ChatNPCManager npcManager) {
        this.npcManager = npcManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        if (args.length != 1) {
            return false;
        }
        npcManager.delete(args[0]);
        return true;
    }
}
