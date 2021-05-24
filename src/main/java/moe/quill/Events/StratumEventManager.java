package moe.quill.Events;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StratumEventManager {

    private final JavaPlugin plugin;
    private final PluginManager pluginManager;
    private static final Logger logger = LoggerFactory.getLogger(StratumEventManager.class.getSimpleName());

    public StratumEventManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.pluginManager = plugin.getServer().getPluginManager();
    }

    //Register events for each given listener
    public void register(Listener... listeners) {

        //Iterate through all of the listeners
        for (final var listener : listeners) {
            pluginManager.registerEvents(listener, plugin); //register the events
            logger.info(String.format("Registering events from -> %s", listener.getClass().getSimpleName())); //Log it
        }
    }
}
