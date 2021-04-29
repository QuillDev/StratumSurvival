package tech.quilldev;

import org.bukkit.plugin.java.JavaPlugin;
import tech.quilldev.Commands.Dev;
import tech.quilldev.Events.PlayerUseItemEvent;

import java.util.Objects;

public final class stratumsurvival extends JavaPlugin {

    @Override
    public void onEnable() {

        var pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerUseItemEvent(this), this);

        // Plugin startup logic
        Objects.requireNonNull(this.getCommand("dev")).setExecutor(new Dev(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
