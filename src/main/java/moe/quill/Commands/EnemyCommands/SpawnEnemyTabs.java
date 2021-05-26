package moe.quill.Commands.EnemyCommands;

import moe.quill.Adventuring.Enemies.EnemyType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpawnEnemyTabs implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        if (args.length == 1) {
            return Arrays.stream(EnemyType.values()).map(Enum::name).collect(Collectors.toList());
        }


        return null;
    }
}
