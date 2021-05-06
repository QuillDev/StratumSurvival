package tech.quilldev;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import tech.quilldev.Commands.ItemGenerator.GenerateItem;
import tech.quilldev.Commands.ItemGenerator.GenerateItemTabs;
import tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BluntWeaponAttributes.*;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.CloakUseWeaponAttribute;
import tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BowWeaponAttributes.BowWeaponAttributeWhisper;
import tech.quilldev.CustomItemsv2.EventHandler.HandleAttributeEvents;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.ShadowDodgeUseWeaponAttribute;
import tech.quilldev.Events.ItemGenerationEvents.GenerateItemOnMobDeath;

import java.util.logging.Logger;

public final class stratumsurvival extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {

        //Register the attribute with the Item Attribute manager
        ItemAttributes.registerAll(
                //Blunt Weapon Attributes
                new BluntWeaponFlatDamageAttribute(new NamespacedKey(this, "blunt_weapon_flat_damage")),
                new BluntWeaponChainAttribute(new NamespacedKey(this, "blunt_weapon_chain_damage")),
                new BluntWeaponCritAttribute(new NamespacedKey(this, "blunt_weapon_critical")),
                new BluntWeaponFlameAttribute(new NamespacedKey(this, "blunt_weapon_flame")),
                new BluntWeaponPercentDamageAttribute(new NamespacedKey(this, "blunt_weapon_percent_damage")),
                new BluntWeaponLifeStealAttribute(new NamespacedKey(this, "blunt_weapon_lifesteal")),
                //Bow Weapon Attributes
                new BowWeaponAttributeWhisper(new NamespacedKey(this, "bow_weapon_whisper")),
                //Use Attributes
                new CloakUseWeaponAttribute(new NamespacedKey(this, "use_cloak")),
                new ShadowDodgeUseWeaponAttribute(new NamespacedKey(this, "use_shadow_dodge"))
        );

        //Register Plugins
        var pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new HandleAttributeEvents(), this);
        pluginManager.registerEvents(new GenerateItemOnMobDeath(), this);

        //Setup any commands
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
