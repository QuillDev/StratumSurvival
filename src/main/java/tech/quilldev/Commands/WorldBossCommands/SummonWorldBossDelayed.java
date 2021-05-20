package tech.quilldev.Commands.WorldBossCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.Bosses.WorldBossManager;

public class SummonWorldBossDelayed implements CommandExecutor {

    private final WorldBossManager bossManager;

    public SummonWorldBossDelayed(WorldBossManager bossManager) {
        this.bossManager = bossManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        bossManager.spawnWithDelay(player.getLocation());
        return true;
    }
}
