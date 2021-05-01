package tech.quilldev;

import org.bukkit.plugin.java.JavaPlugin;
import tech.quilldev.Commands.Dev;
import tech.quilldev.CustomItems.ItemGenerator;
import tech.quilldev.Events.OnEntityDamage;
import tech.quilldev.Events.GenerateItemOnMobDeath;
import tech.quilldev.Events.PlayerUseItemEvent;
import tech.quilldev.ItemAttributes.ItemAttributes;

import java.util.Objects;

public final class stratumsurvival extends JavaPlugin {


    @Override
    public void onEnable() {

        //Create unique generators etc.
        final var attributes = new ItemAttributes(this);
        final var itemGenerator = new ItemGenerator(attributes);

        //Register Plugins
        var pluginManager = getServer().getPluginManager();

        //Handle item generation
        pluginManager.registerEvents(new GenerateItemOnMobDeath(itemGenerator), this);

        //Handle item usage
        pluginManager.registerEvents(new PlayerUseItemEvent(attributes.useAttributes), this);
        pluginManager.registerEvents(new OnEntityDamage(attributes.damageAttributes), this);
        // Plugin startup logic
        Objects.requireNonNull(this.getCommand("dev")).setExecutor(new Dev(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
