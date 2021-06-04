package moe.quill.stratumsurvival.Commands.EnemyCommands;

import com.google.inject.Inject;
import moe.quill.stratumsurvival.Adventuring.Enemies.EnemyManager;
import moe.quill.stratumsurvival.Adventuring.Enemies.EnemyType;
import moe.quill.stratumsurvival.Commands.PlayerCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SpawnEnemy implements CommandExecutor, PlayerCommand {

    private final EnemyManager enemyManager;

    @Inject
    public SpawnEnemy(EnemyManager enemyManager) {
        this.enemyManager = enemyManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        final var player = getPlayerFromSender(sender);
        if (player == null) return true;
        enemyManager.spawnEnemyOfType(player.getLocation(), EnemyType.valueOf(args[0]));
        return true;
    }
}
