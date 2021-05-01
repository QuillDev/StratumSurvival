package tech.quilldev;

import org.bukkit.plugin.java.JavaPlugin;
import tech.quilldev.Commands.Dev;
import tech.quilldev.CustomItems.ItemGenerator;
import tech.quilldev.Events.AnimalEvents.RatsCantSitEvent;
import tech.quilldev.Events.AttributeEvents.HandleDamageAttributeEvent;
import tech.quilldev.Events.AttributeEvents.HandleDeathAttributeEvent;
import tech.quilldev.Events.AttributeEvents.HandleUseAttributeEvent;
import tech.quilldev.Events.ItemCreationEvents.GenerateItemOnMobDeath;
import tech.quilldev.ItemAttributes.ItemAttributes;

import java.util.Objects;
import java.util.logging.Logger;

public final class stratumsurvival extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");

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
        pluginManager.registerEvents(new HandleUseAttributeEvent(attributes.useAttributes), this);
        pluginManager.registerEvents(new HandleDamageAttributeEvent(attributes.damageAttributes), this);
        pluginManager.registerEvents(new HandleDeathAttributeEvent(attributes.deathAttributes), this);

        //Handle Rat stuff
        pluginManager.registerEvents(new RatsCantSitEvent(), this);
        // Plugin startup logic
        Objects.requireNonNull(this.getCommand("dev")).setExecutor(new Dev(attributes));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
