package moe.quill.Commands.AdventureCommands.WorldBossCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import moe.quill.Adventuring.Bosses.WorldBossManager;

public class WorldBossTeleportCommand implements CommandExecutor {

    private final WorldBossManager bossManager;

    public WorldBossTeleportCommand(WorldBossManager bossManager) {
        this.bossManager = bossManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        final var world = Bukkit.getWorld("worldbossworld");
        if (world == null) return true;
        player.teleport(world.getSpawnLocation());
        return true;
    }
}
