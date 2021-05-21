package tech.quilldev;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import tech.quilldev.Bosses.WorldBossManager;
import tech.quilldev.Commands.*;
import tech.quilldev.Commands.ItemGenerator.DeobfuscateItem;
import tech.quilldev.Commands.ItemGenerator.GenerateItem;
import tech.quilldev.Commands.ItemGenerator.GenerateItemTabs;
import tech.quilldev.Commands.ItemGenerator.ObfuscateItem;
import tech.quilldev.Commands.NPCCommands.ChatNPCCommands.AddChatLines.AddChatLineTabs;
import tech.quilldev.Commands.NPCCommands.ChatNPCCommands.AddChatLines.AddChatLineCommand;
import tech.quilldev.Commands.NPCCommands.ChatNPCCommands.DeleteChatNpc.DeleteChatNpcCommand;
import tech.quilldev.Commands.NPCCommands.ChatNPCCommands.DeleteChatNpc.DeleteChatNpcTabs;
import tech.quilldev.Commands.NPCCommands.ChatNPCCommands.RemoveChatLine.RemoveChatLineCommand;
import tech.quilldev.Commands.NPCCommands.ChatNPCCommands.RemoveChatLine.RemoveChatLineRawCommand;
import tech.quilldev.Commands.NPCCommands.ChatNPCCommands.SpawnChatNpcCommand;
import tech.quilldev.Commands.NPCCommands.SpawnNPCCommand;
import tech.quilldev.Commands.WorldBossCommands.SummonWorldBossCommand;
import tech.quilldev.Commands.WorldBossCommands.SummonWorldBossDelayedCommand;
import tech.quilldev.Commands.WorldBossCommands.WorldBossTeleportCommand;
import tech.quilldev.Crafting.CustomCraftingEvents.CraftCustomItemEvent;
import tech.quilldev.Crafting.CustomCraftingEvents.GrindCustomWeaponEvent;
import tech.quilldev.Crafting.StratumCraftingManager;
import tech.quilldev.Crafting.StratumRecipes.Materials.FragmentRecipes.*;
import tech.quilldev.Crafting.StratumRecipes.Weapons.Battleaxes.*;
import tech.quilldev.Crafting.StratumRecipes.Weapons.Daggers.*;
import tech.quilldev.CustomItems.Attributes.OnDeathAttributes.*;
import tech.quilldev.CustomItems.Attributes.UseAttributes.JumpBoostUseWeaponAttribute;
import tech.quilldev.CustomItems.Attributes.UseAttributes.SlowFeildUseWeaponAttribute;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import tech.quilldev.Crafting.StratumRecipes.Materials.ShardRecipes.ShardCommonToUncommonRecipe;
import tech.quilldev.Crafting.StratumRecipes.Materials.ShardRecipes.ShardEpicToLegendary;
import tech.quilldev.Crafting.StratumRecipes.Materials.ShardRecipes.ShardRareToEpicRecipe;
import tech.quilldev.Crafting.StratumRecipes.Materials.ShardRecipes.ShardUncommonToRareRecipe;
import tech.quilldev.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes.*;
import tech.quilldev.CustomItems.Attributes.AttackAttributes.BowWeaponAttributes.BowWeaponAttributeDamage;
import tech.quilldev.CustomItems.Attributes.UseAttributes.CloakUseWeaponAttribute;
import tech.quilldev.CustomItems.EventHandler.HandleAttributeEvents;
import tech.quilldev.CustomItems.Attributes.ItemAttributes;
import tech.quilldev.CustomItems.Attributes.UseAttributes.ShadowDodgeUseWeaponAttribute;
import tech.quilldev.CustomItems.ItemHelpers.ItemGenerator;
import tech.quilldev.CustomItems.MaterialManager.WeaponLists;
import tech.quilldev.Events.ChatEvents.InjectChatItemEvent;
import tech.quilldev.Events.ItemGenerationEvents.GenerateItemOnMobDeath;
import tech.quilldev.Events.TestEvents.DaggerBackstabEvent;
import tech.quilldev.Events.ToolEvents.ToolBreakBlockDropShard;
import tech.quilldev.NPCManager.ChatNPC.ChatNPCManager;
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
        StratumSerialization.init();

        //Init the item attributes manager
        final var itemAttributes = new ItemAttributes(this);
        final var materialManager = new StratumMaterialManager(this);
        final var chatNpcManager = new ChatNPCManager(this);
        final var worldBossManager = new WorldBossManager(this);
        new WeaponLists(materialManager);
        itemAttributes.init(materialManager);

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
                new BluntWeaponSpeedStealAttribute(new NamespacedKey(this, "blunt_weapon_speedsteal")),
                new BluntWeaponEvokerStrikeAttribute(new NamespacedKey(this, "blunt_weapon_evokerstrike")),
                new BluntWeaponFeintAttribute(new NamespacedKey(this, "blunt_weapon_feint")),
                //Bow Weapon Attributes
                new BowWeaponAttributeDamage(new NamespacedKey(this, "bow_damage")),
                //Use Attributes
                new CloakUseWeaponAttribute(new NamespacedKey(this, "use_cloak")),
                new ShadowDodgeUseWeaponAttribute(new NamespacedKey(this, "use_shadow_dodge")),
                new SlowFeildUseWeaponAttribute(new NamespacedKey(this, "use_slow_feild")),
                new JumpBoostUseWeaponAttribute(new NamespacedKey(this, "use_jump_feild")),

                //Death Attributes
                new WhisperOnDeath(new NamespacedKey(this, "on_death_whisper")),
                new DropGoldOnDeathAttribute(new NamespacedKey(this, "on_Death_gold")),
                new DropIronOnDeathAttribute(new NamespacedKey(this, "on_Death_iron")),
                new SpeedPoolOnDeathAttribute(new NamespacedKey(this, "on_death_speed_pool")),
                new LifePoolOnDeathAttribute(new NamespacedKey(this, "on_death_life_pool"))
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
        pluginManager.registerEvents(new ToolBreakBlockDropShard(materialManager), this);

        //Register crafting
        craftingManager.registerAll(
                //BATTLEAXE RECIPES
                new CraftBattleaxeWooden(new NamespacedKey(this, "craft_battleaxe_wooden"), materialManager),
                new CraftBattleaxeStone(new NamespacedKey(this, "craft_battleaxe_stone"), materialManager),
                new CraftBattleaxeGolden(new NamespacedKey(this, "craft_battleaxe_golden"), materialManager),
                new CraftBattleaxeIron(new NamespacedKey(this, "craft_battleaxe_iron"), materialManager),
                new CraftBattleaxeDiamond(new NamespacedKey(this, "craft_battleaxe_diamond"), materialManager),
                new CraftBattleaxeNetherite(new NamespacedKey(this, "smith_battleaxe_netherite"), materialManager),
                //DAGGER RECIPES
                new CraftDaggerWooden(new NamespacedKey(this, "craft_dagger_wooden"), materialManager),
                new CraftDaggerStone(new NamespacedKey(this, "craft_dagger_stone"), materialManager),
                new CraftDaggerGolden(new NamespacedKey(this, "craft_dagger_golden"), materialManager),
                new CraftDaggerIron(new NamespacedKey(this, "craft_dagger_iron"), materialManager),
                new CraftDaggerDiamond(new NamespacedKey(this, "craft_dagger_diamond"), materialManager),
                new CraftDaggerNetherite(new NamespacedKey(this, "smith_dagger_netherite"), materialManager),
                // Add shard crafting recipes
                new ShardCommonToUncommonRecipe(new NamespacedKey(this, "craft_shard_common_to_uncommon"), materialManager),
                new ShardUncommonToRareRecipe(new NamespacedKey(this, "craft_shard_uncommon_to_rare"), materialManager),
                new ShardRareToEpicRecipe(new NamespacedKey(this, "craft_shard_rare_to_epic"), materialManager),
                new ShardEpicToLegendary(new NamespacedKey(this, "craft_shard_epic_to_legendary"), materialManager),

                //Add Fragment Crafting Recipes
                new FragmentToShardCommon(new NamespacedKey(this, "craft_fragment_to_shard_common"), materialManager),
                new FragmentToShardUncommon(new NamespacedKey(this, "craft_fragment_to_shard_uncommon"), materialManager),
                new FragmentToShardRare(new NamespacedKey(this, "craft_fragment_to_shard_rare"), materialManager),
                new FragmentToShardEpic(new NamespacedKey(this, "craft_fragment_to_shard_epic"), materialManager),
                new FragmentToShardLegendary(new NamespacedKey(this, "craft_fragment_to_shard_legendary"), materialManager)

        );

        //Setup any commands
        final var generateItemCommand = this.getCommand("generateitem");
        if (generateItemCommand != null) {
            generateItemCommand.setExecutor(new GenerateItem(itemGenerator));
            generateItemCommand.setTabCompleter(new GenerateItemTabs());
        }

        final var addChatLineCommand = this.getCommand("addchatline");
        if (addChatLineCommand != null) {
            addChatLineCommand.setExecutor(new AddChatLineCommand(chatNpcManager));
            addChatLineCommand.setTabCompleter(new AddChatLineTabs(chatNpcManager));
        }

        final var deleteChatNpc = this.getCommand("deletechatnpc");
        if (deleteChatNpc != null) {
            deleteChatNpc.setExecutor(new DeleteChatNpcCommand(chatNpcManager));
            deleteChatNpc.setTabCompleter(new DeleteChatNpcTabs(chatNpcManager));
        }

        //Register the chat line command
        final var removeChatLine = this.getCommand("removechatline");
        if (removeChatLine != null) {
            removeChatLine.setExecutor(new RemoveChatLineCommand(chatNpcManager));
            removeChatLine.setTabCompleter(new DeleteChatNpcTabs(chatNpcManager));
        }

        //Register the raw chat line command
        final var removeChatLineRaw = this.getCommand("removechatlineraw");
        if (removeChatLineRaw != null) {
            removeChatLineRaw.setExecutor(new RemoveChatLineRawCommand(chatNpcManager));
        }

        Objects.requireNonNull(this.getCommand("obfuscate")).setExecutor(new ObfuscateItem());
        Objects.requireNonNull(this.getCommand("deobfuscate")).setExecutor(new DeobfuscateItem());
        Objects.requireNonNull(this.getCommand("spawnnpc")).setExecutor(new SpawnNPCCommand(npcManager));
        Objects.requireNonNull(this.getCommand("reroll")).setExecutor(new RerollItem());
        Objects.requireNonNull(this.getCommand("devtool")).setExecutor(new DevTool(materialManager));
        Objects.requireNonNull(this.getCommand("spawnchatnpc")).setExecutor(new SpawnChatNpcCommand(chatNpcManager));
        Objects.requireNonNull(this.getCommand("spawnworldboss")).setExecutor(new SummonWorldBossCommand(worldBossManager));
        Objects.requireNonNull(this.getCommand("spawnworldbossdelayed")).setExecutor(new SummonWorldBossDelayedCommand(worldBossManager));
        Objects.requireNonNull(this.getCommand("worldbosstp")).setExecutor(new WorldBossTeleportCommand(worldBossManager));


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
