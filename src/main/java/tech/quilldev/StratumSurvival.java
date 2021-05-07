package tech.quilldev;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import tech.quilldev.Commands.Dev;
import tech.quilldev.Commands.ItemGenerator.DeobfuscateItem;
import tech.quilldev.Commands.ItemGenerator.GenerateItem;
import tech.quilldev.Commands.ItemGenerator.GenerateItemTabs;
import tech.quilldev.Commands.ItemGenerator.ObfuscateItem;
import tech.quilldev.Commands.SpawnNPCCommand;
import tech.quilldev.Crafting.CustomCraftingEvents.GrindCustomWeaponEvent;
import tech.quilldev.Crafting.StratumCraftingManager;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumRecipes.CraftBattleAxe;
import tech.quilldev.Crafting.StratumRecipes.TestRecipe;
import tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BluntWeaponAttributes.*;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.CloakUseWeaponAttribute;
import tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BowWeaponAttributes.BowWeaponAttributeWhisper;
import tech.quilldev.CustomItemsv2.EventHandler.HandleAttributeEvents;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.ShadowDodgeUseWeaponAttribute;
import tech.quilldev.Events.ChatEvents.InjectChatItemEvent;
import tech.quilldev.Events.ItemGenerationEvents.GenerateItemOnMobDeath;
import tech.quilldev.NPCManager.NPCEvents.InteractCryptologistEvent;
import tech.quilldev.NPCManager.NPCManager;
import tech.quilldev.Serialization.StratumSerialization;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class StratumSurvival extends JavaPlugin {

    private static final Logger logger = Logger.getLogger("Minecraft");
    private final StratumCraftingManager craftingManager = new StratumCraftingManager(getServer());
    private final NPCManager npcManager = new NPCManager(this);

    @Override
    public void onEnable() {
        log(getClass(), "Enabled!");

        //Init the item attributes manager
        StratumSerialization.init();
        ItemAttributes.init(this);
        StratumMaterial.init();

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

        //Register Events
        var pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new HandleAttributeEvents(), this);
        pluginManager.registerEvents(new GenerateItemOnMobDeath(), this);
        pluginManager.registerEvents(new InjectChatItemEvent(), this);
        pluginManager.registerEvents(new GrindCustomWeaponEvent(), this);
        pluginManager.registerEvents(new InteractCryptologistEvent(npcManager), this);

        //Register crafting
        craftingManager.registerAll(
                new TestRecipe(new NamespacedKey(this, "craft_test_recipe")),
                new CraftBattleAxe(new NamespacedKey(this, "craft_battleaxe_netherite"))
        );

        //Setup any commands
        final var generateItemCommand = this.getCommand("generateitem");
        if (generateItemCommand != null) {
            generateItemCommand.setExecutor(new GenerateItem());
            generateItemCommand.setTabCompleter(new GenerateItemTabs());
        }

        Objects.requireNonNull(this.getCommand("dev")).setExecutor(new Dev());
        Objects.requireNonNull(this.getCommand("obfuscate")).setExecutor(new ObfuscateItem());
        Objects.requireNonNull(this.getCommand("deobfuscate")).setExecutor(new DeobfuscateItem());
        Objects.requireNonNull(this.getCommand("spawnnpc")).setExecutor(new SpawnNPCCommand(npcManager));
    }

    @Override
    public void onDisable() {
        log(getClass(), "Disabled!");
        craftingManager.disable();
        // Plugin shutdown logic
    }

    public static void log(Level logLevel, Class<?> parent, String name) {
        logger.log(logLevel, String.format("[%s] %s", parent.getSimpleName(), name));
    }

    public static void log(Class<?> parent, String name) {
        log(Level.INFO, parent, name);
    }
}
