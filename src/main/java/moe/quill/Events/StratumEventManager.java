package moe.quill.Events;

import com.google.inject.Inject;
import moe.quill.StratumSurvival;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StratumEventManager {

    private final JavaPlugin plugin;
    private final PluginManager pluginManager;
    private static final Logger logger = LoggerFactory.getLogger(StratumEventManager.class.getSimpleName());

    @Inject
    public StratumEventManager(Plugin plugin) {
        this.plugin = (JavaPlugin) plugin;
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
