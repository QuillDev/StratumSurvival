package moe.quill.stratumsurvival.Commands.NPCCommands.ChatNPCCommands.AddChatLines;

import moe.quill.stratumsurvival.Adventuring.NPCManager.ChatNPC.ChatNPCManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AddChatLineTabs implements TabCompleter {

    private final ChatNPCManager chatNPCManager;

    public AddChatLineTabs(ChatNPCManager chatNPCManager) {
        this.chatNPCManager = chatNPCManager;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            return new ArrayList<>(chatNPCManager.getChatNPCs().keySet());
        }
        return null;
    }
}
