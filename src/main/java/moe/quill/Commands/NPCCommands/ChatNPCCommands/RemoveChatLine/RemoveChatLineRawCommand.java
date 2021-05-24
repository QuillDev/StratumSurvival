package moe.quill.Commands.NPCCommands.ChatNPCCommands.RemoveChatLine;

import moe.quill.Adventuring.NPCManager.ChatNPC.ChatNPCManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RemoveChatLineRawCommand implements CommandExecutor {

    private final ChatNPCManager npcManager;

    public RemoveChatLineRawCommand(ChatNPCManager npcManager) {
        this.npcManager = npcManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        if (args.length != 2) return false;


        //Get the NPC
        final var npc = npcManager.getNpcFromName(args[0]);
        final var index = Integer.parseInt(args[1]); //get the line index to remove
        final var lines = npc.getChatLines(); //get all of the npcs chat lines

        //If the index is out of bounds for the lines, exit the command
        if (index < 0 || index > lines.size() - 1) return true;
        final var line = lines.get(index);
        npc.removeChatLine(index);

        player.sendMessage(
                Component.text("Removed chat line")
                        .append(Component.space())
                        .append(Component.text("\""))
                        .append(line)
                        .append(Component.text("\"!"))
                .color(TextColor.color(0xBD92B))

        );
        return true;
    }
}
