package tech.quilldev;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.plugin.java.JavaPlugin;
import tech.quilldev.Commands.ItemGenerator.GenerateItem;
import tech.quilldev.Commands.ItemGenerator.GenerateItemTabs;
import tech.quilldev.CustomItemsv2.AttackAttributes.BluntWeaponAttributes.*;
import tech.quilldev.CustomItemsv2.Effects.CritDamageEffect;
import tech.quilldev.CustomItemsv2.UseAttributes.CloakUseWeaponAttribute;
import tech.quilldev.CustomItemsv2.AttackAttributes.BowWeaponAttributes.BowWeaponAttributeWhisper;
import tech.quilldev.CustomItemsv2.EventHandler.HandleAttributeEvents;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.CustomItemsv2.UseAttributes.ShadowDodgeUseWeaponAttribute;
import tech.quilldev.Events.ItemGenerationEvents.GenerateItemOnMobDeath;

import javax.naming.Name;
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
        ItemAttributes.register(new ShadowDodgeUseWeaponAttribute(new NamespacedKey(this, "shodow_dodge")));
        ItemAttributes.register(new BluntWeaponCritAttribute(new NamespacedKey( this, "blunt_weapon_crit")));
        ItemAttributes.register(new BluntWeaponFlameAttribute(new NamespacedKey(this, "blunt_weapon_flame")));
        ItemAttributes.register(new BluntWeaponPercentDamageAttribute(new NamespacedKey(this, "blunt_weapon_percent_damage")));
        ItemAttributes.register(new BluntWeaponLifeStealAttribute(new NamespacedKey(this, "blunt_weapon_lifesteal")));

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
