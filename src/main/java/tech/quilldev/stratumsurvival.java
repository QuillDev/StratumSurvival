package tech.quilldev;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import tech.quilldev.Commands.Dev;
import tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes.BluntWeaponChainAttribute;
import tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes.BluntWeaponFlatDamageAttribute;
import tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes.BluntWeaponWhisperAttribute;
import tech.quilldev.CustomItemsv2.EventHandler.HandleAttributeEvents;
import tech.quilldev.CustomItemsv2.ItemAttributes;

import java.util.Objects;
import java.util.logging.Logger;

public final class stratumsurvival extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {

        //Regiser the attribute with the Item Attribute manager
        ItemAttributes.register(new BluntWeaponWhisperAttribute(new NamespacedKey(this, "blunt_weapon_whisper")));
        ItemAttributes.register(new BluntWeaponFlatDamageAttribute(new NamespacedKey(this, "blunt_weapon_flat_damage")));
        ItemAttributes.register(new BluntWeaponChainAttribute(new NamespacedKey(this, "blunt_weapon_chain_damage")));

        //Register Plugins
        var pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new HandleAttributeEvents(), this);

        Objects.requireNonNull(this.getCommand("dev")).setExecutor(new Dev());

//        TODO: REWRITE LEGACY ITEM SYSTEM
//        pluginManager.registerEvents(new GenerateItemOnMobDeath(itemGenerator), this);
//
//        //Handle item usage
//        pluginManager.registerEvents(new HandleOnUseAttributeEvent(attributes.onUseAttributes), this);
//        pluginManager.registerEvents(new HandleOnHitAttributeEvent(attributes.onHitAttributes), this);
//        pluginManager.registerEvents(new HandleOnDeathAttributeEvent(attributes.onDeathAttributes), this);
//        pluginManager.registerEvents(new ToolBlockBreakEvent(attributes.toolAttributes), this);
//        //Handle Rat stuff
//        pluginManager.registerEvents(new RatsCantSitEvent(), this);
//
//        // Plugin startup logic
//        Objects.requireNonNull(this.getCommand("devtool")).setExecutor(new DevTool(attributes));
//        Objects.requireNonNull(this.getCommand("playinggod")).setExecutor(new SpawnCustomMob());
//
//        final var createRandomItemCommand = this.getCommand("createrandomitem");
//        if (createRandomItemCommand != null) {
//            createRandomItemCommand.setExecutor(new CreateRandomItemCommand(itemGenerator));
//            createRandomItemCommand.setTabCompleter(new CreateRandomItemCommandTabs());
//        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
