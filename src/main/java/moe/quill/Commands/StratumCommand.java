package moe.quill.Commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.Nullable;

public class StratumCommand {

    private final String name;
    private final CommandExecutor executor;
    private final TabCompleter tabCompleter;

    public StratumCommand(String name, CommandExecutor executor, @Nullable TabCompleter tabCompleter) {
        this.name = name;
        this.executor = executor;
        this.tabCompleter = tabCompleter;
    }

    public String getName() {
        return name;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

    public TabCompleter getTabCompleter() {
        return tabCompleter;
    }
}
