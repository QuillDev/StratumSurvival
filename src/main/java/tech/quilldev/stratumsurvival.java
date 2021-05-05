package tech.quilldev;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import tech.quilldev.Commands.Dev;
import tech.quilldev.Commands.ItemGenerator.GenerateItem;
import tech.quilldev.Commands.ItemGenerator.GenerateItemTabs;
import tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes.BluntWeaponChainAttribute;
import tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes.BluntWeaponFlatDamageAttribute;
import tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes.CloakUseWeaponAttribute;
import tech.quilldev.CustomItemsv2.AttackAttributes.BowWeaponAttributes.BowWeaponAttributeWhisper;
import tech.quilldev.CustomItemsv2.EventHandler.HandleAttributeEvents;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.Events.ItemGenerationEvents.GenerateItemOnMobDeath;
import tech.quilldev.Names.Names;

import java.util.Objects;
import java.util.logging.Logger;

public final class stratumsurvival extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {

        //Register the attribute with the Item Attribute manager
        ItemAttributes.register(new BluntWeaponFlatDamageAttribute(new NamespacedKey(this, "blunt_weapon_flat_damage")));
        ItemAttributes.register(new BluntWeaponChainAttribute(new NamespacedKey(this, "blunt_weapon_chain_damage")));
        ItemAttributes.register(new BowWeaponAttributeWhisper(new NamespacedKey(this, "bow_weapon_whisper")));
        ItemAttributes.register(new CloakUseWeaponAttribute(new NamespacedKey(this,"cloak")));

        //Register Plugins
        var pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new HandleAttributeEvents(), this);
        pluginManager.registerEvents(new GenerateItemOnMobDeath(), this);

        final var generateItemCommand = this.getCommand("generateitem");
        if (generateItemCommand != null) {
            generateItemCommand.setExecutor(new GenerateItem());
            generateItemCommand.setTabCompleter(new GenerateItemTabs());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
