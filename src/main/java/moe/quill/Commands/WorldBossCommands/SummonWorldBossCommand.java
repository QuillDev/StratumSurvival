package moe.quill.Commands.WorldBossCommands;

import moe.quill.Bosses.WorldBossManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class SummonWorldBossCommand implements CommandExecutor, Listener {

    private final WorldBossManager bossManager;

    public SummonWorldBossCommand(WorldBossManager bossManager) {
        this.bossManager = bossManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        bossManager.spawnWorldBoss(player.getLocation());
        return true;
    }
}
