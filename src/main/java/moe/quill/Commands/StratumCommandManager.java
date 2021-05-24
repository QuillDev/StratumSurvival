package moe.quill.Commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import moe.quill.StratumSurvival;

public class StratumCommandManager {


    private final StratumSurvival plugin;
    private static final Logger logger = LoggerFactory.getLogger(StratumCommandManager.class.getSimpleName());


    public StratumCommandManager(StratumSurvival plugin) {
        this.plugin = plugin;
        register(); //register all of the commands
    }


    public void register(StratumCommand... stratumCommands) {

        //Register commands for each stratum command
        for (final var command : stratumCommands) {
            final var pluginCommand = plugin.getCommand(command.getName());

            //If the command does not exist log it
            if (pluginCommand == null) {
                logger.warn(String.format("Could not find a command with the name '%s'", command.getName()));
                return;
            }

            //Set the executor of the command
            pluginCommand.setExecutor(command.getExecutor());
            if (command.getTabCompleter() == null) return; // if this command has no tab completer, return null
            pluginCommand.setTabCompleter(command.getTabCompleter());
        }
    }
}
