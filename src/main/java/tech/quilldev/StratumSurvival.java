package tech.quilldev;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import tech.quilldev.Commands.DevTool;
import tech.quilldev.Commands.ItemGenerator.DeobfuscateItem;
import tech.quilldev.Commands.ItemGenerator.GenerateItem;
import tech.quilldev.Commands.ItemGenerator.GenerateItemTabs;
import tech.quilldev.Commands.ItemGenerator.ObfuscateItem;
import tech.quilldev.Commands.RerollItem;
import tech.quilldev.Commands.SpawnNPCCommand;
import tech.quilldev.Crafting.CustomCraftingEvents.CraftCustomItemEvent;
import tech.quilldev.Crafting.CustomCraftingEvents.GrindCustomWeaponEvent;
import tech.quilldev.Crafting.StratumCraftingManager;
import tech.quilldev.Crafting.StratumMaterialManager;
import tech.quilldev.Crafting.StratumRecipes.Battleaxes.CraftBattleaxeWooden;
import tech.quilldev.Crafting.StratumRecipes.Battleaxes.CraftDiamondBattleAxe;
import tech.quilldev.Crafting.StratumRecipes.Battleaxes.CraftIronBattleAxe;
import tech.quilldev.Crafting.StratumRecipes.Battleaxes.CraftBattleaxeNetherite;
import tech.quilldev.Crafting.StratumRecipes.CrystalRecipes.ShardCommonToUncommonRecipe;
import tech.quilldev.Crafting.StratumRecipes.CrystalRecipes.ShardEpicToLegendary;
import tech.quilldev.Crafting.StratumRecipes.CrystalRecipes.ShardRareToEpicRecipe;
import tech.quilldev.Crafting.StratumRecipes.CrystalRecipes.ShardUncommonToRareRecipe;
import tech.quilldev.Crafting.StratumRecipes.TestRecipe;
import tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BluntWeaponAttributes.*;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.CloakUseWeaponAttribute;
import tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BowWeaponAttributes.BowWeaponAttributeWhisper;
import tech.quilldev.CustomItemsv2.EventHandler.HandleAttributeEvents;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.ShadowDodgeUseWeaponAttribute;
import tech.quilldev.CustomItemsv2.ItemHelpers.ItemGenerator;
import tech.quilldev.CustomItemsv2.WeaponLists;
import tech.quilldev.Events.ChatEvents.InjectChatItemEvent;
import tech.quilldev.Events.ItemGenerationEvents.GenerateItemOnMobDeath;
import tech.quilldev.Events.TestEvents.DaggerBackstabEvent;
import tech.quilldev.NPCManager.NPCEvents.InteractBlacksmithEvent;
import tech.quilldev.NPCManager.NPCEvents.InteractCryptologistEvent;
import tech.quilldev.NPCManager.NPCEvents.NPCTransformWitchCancel;
import tech.quilldev.NPCManager.NPCManager;
import tech.quilldev.Serialization.StratumSerialization;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class StratumSurvival extends JavaPlugin {

    private static final Logger logger = Logger.getLogger("Minecraft");
    private StratumCraftingManager craftingManager = new StratumCraftingManager(this);
    private final NPCManager npcManager = new NPCManager(this);


    @Override
    public void onEnable() {
        log(getClass(), "Enabled!");

        //Init the item attributes manager
        final var itemAttributes = new ItemAttributes(this);
        final var materialManager = new StratumMaterialManager(this);
        new WeaponLists(materialManager);
        itemAttributes.init(materialManager);


        StratumSerialization.init();

        //Create a material manager

        final var itemGenerator = new ItemGenerator(materialManager);
        //TODO: Load+Cache all materials we're going to be using here


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
        pluginManager.registerEvents(new GenerateItemOnMobDeath(itemGenerator), this);
        pluginManager.registerEvents(new InjectChatItemEvent(), this);
        pluginManager.registerEvents(new GrindCustomWeaponEvent(materialManager), this);
        pluginManager.registerEvents(new InteractCryptologistEvent(npcManager), this);
        pluginManager.registerEvents(new InteractBlacksmithEvent(npcManager, materialManager), this);
        pluginManager.registerEvents(new CraftCustomItemEvent(itemGenerator, materialManager), this);
        pluginManager.registerEvents(new NPCTransformWitchCancel(), this);
        pluginManager.registerEvents(new DaggerBackstabEvent(materialManager), this);

        //Register crafting
        craftingManager.registerAll(
                new CraftBattleaxeNetherite(new NamespacedKey(this, "smith_battleaxe_netherite"), materialManager),
                new CraftIronBattleAxe(new NamespacedKey(this, "craft_battleaxe_iron"), materialManager),
                new CraftDiamondBattleAxe(new NamespacedKey(this, "craft_battleaxe_diamond"), materialManager),
                new CraftBattleaxeWooden(new NamespacedKey(this, "craft_battleaxe_wooden"), materialManager),
                // Add shard crafting recipes
                new ShardCommonToUncommonRecipe(new NamespacedKey(this, "craft_shard_common_to_uncommon"), materialManager),
                new ShardUncommonToRareRecipe(new NamespacedKey(this, "craft_shard_uncommon_to_rare"), materialManager),
                new ShardRareToEpicRecipe(new NamespacedKey(this, "craft_shard_rare_to_epic"), materialManager),
                new ShardEpicToLegendary(new NamespacedKey(this, "craft_shard_epic_to_legendary"), materialManager),
                new TestRecipe(new NamespacedKey(this, "craft_test_recipe"), materialManager)
        );

        //Setup any commands
        final var generateItemCommand = this.getCommand("generateitem");
        if (generateItemCommand != null) {
            generateItemCommand.setExecutor(new GenerateItem(itemGenerator));
            generateItemCommand.setTabCompleter(new GenerateItemTabs());
        }


        Objects.requireNonNull(this.getCommand("obfuscate")).setExecutor(new ObfuscateItem());
        Objects.requireNonNull(this.getCommand("deobfuscate")).setExecutor(new DeobfuscateItem());
        Objects.requireNonNull(this.getCommand("spawnnpc")).setExecutor(new SpawnNPCCommand(npcManager));
        Objects.requireNonNull(this.getCommand("reroll")).setExecutor(new RerollItem());
        Objects.requireNonNull(this.getCommand("devtool")).setExecutor(new DevTool(materialManager));
        craftingManager.registerDynamicRecipes(materialManager);

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
