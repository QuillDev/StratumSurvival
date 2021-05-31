package moe.quill.stratumsurvival.Commands.NPCCommands.ChatNPCCommands.DeleteChatNpc;

import moe.quill.stratumsurvival.Adventuring.NPCManager.ChatNPC.ChatNPCManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DeleteChatNpcTabs implements TabCompleter {

    private final ChatNPCManager npcManager;

    public DeleteChatNpcTabs(ChatNPCManager npcManager) {
        this.npcManager = npcManager;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            return new ArrayList<>(npcManager.getChatNPCs().keySet());
        }
        return null;
    }
}
