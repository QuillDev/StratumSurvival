package tech.quilldev.Commands;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.NPCManager.NPCManager;
import tech.quilldev.NPCManager.NPCs.NPCType;

public class SpawnNPCCommand implements CommandExecutor {

    private final NPCManager npcManager;

    public SpawnNPCCommand(NPCManager npcManager) {
        this.npcManager = npcManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //Make sure the args and sender are valid
        if (args.length == 0) return true;
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;

        //Get the NPC matching the given key
        final var npc = npcManager.getNPCByType(NPCType.CRYPTOLOGIST);
        if (npc == null) return true;

        //Spawn the NPC at the players location
        npc.spawn(player.getLocation(), Component.text("POGGERS"));
        return false;
    }
}