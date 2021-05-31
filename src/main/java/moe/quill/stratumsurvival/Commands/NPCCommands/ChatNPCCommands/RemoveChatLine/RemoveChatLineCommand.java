package moe.quill.stratumsurvival.Commands.NPCCommands.ChatNPCCommands.RemoveChatLine;

import moe.quill.stratumsurvival.Adventuring.NPCManager.ChatNPC.ChatNPCManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RemoveChatLineCommand implements CommandExecutor {

    private final ChatNPCManager npcManager;

    public RemoveChatLineCommand(ChatNPCManager npcManager) {
        this.npcManager = npcManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        if (args.length != 1) return true;
        final var npc = npcManager.getNpcFromName(args[0]);
        var lines = npc.getChatLines();

        //If there are no lines to remove, tell the player
        if (lines.size() == 0) {
            player.sendMessage("This NPC has no chat lines to remove!");
            return true;
        }

        //Tell then player how to use the command
        player.sendMessage(
                Component.text("Click the line you would like to remove!")
                .color(TextColor.color(0xE04B46))
        );

        //Loop and print chat events for each line to remove it
        for (var i = 0; i < lines.size(); i++) {
            final var line = lines.get(i);
            final var lineToSend =
                    Component.text((i + 1) + ") ")
                            .append(line)
                            .clickEvent(
                                    ClickEvent.clickEvent(
                                            ClickEvent.Action.RUN_COMMAND,
                                            "/removechatlineraw " + args[0] + " " + i
                                    )
                            )
                            .color(TextColor.color(0x53C35E));
            player.sendMessage(lineToSend);
        }

        return true;
    }
}
