package moe.quill;

import moe.quill.Adventuring.Bosses.WorldBossManager;
import moe.quill.Adventuring.Enemies.Enemy;
import moe.quill.Adventuring.Enemies.EnemyManager;
import moe.quill.Commands.EnemyCommands.SpawnEnemyTabs;
import moe.quill.Commands.Misc.DevTool;
import moe.quill.Commands.EnemyCommands.SpawnEnemy;
import moe.quill.Commands.ItemCommands.DeobfuscateItem;
import moe.quill.Commands.ItemCommands.GenerateItem;
import moe.quill.Commands.ItemCommands.GenerateItemTabs;
import moe.quill.Commands.ItemCommands.ObfuscateItem;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.AddChatLines.AddChatLineCommand;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.AddChatLines.AddChatLineTabs;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.DeleteChatNpc.DeleteChatNpcCommand;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.DeleteChatNpc.DeleteChatNpcTabs;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.RemoveChatLine.RemoveChatLineCommand;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.RemoveChatLine.RemoveChatLineRawCommand;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.SpawnChatNpcCommand;
import moe.quill.Commands.NPCCommands.SpawnNPCCommand;
import moe.quill.Commands.ItemCommands.RerollItem;
import moe.quill.Commands.StratumCommand;
import moe.quill.Commands.StratumCommandManager;
import moe.quill.Commands.AdventureCommands.WorldBossCommands.SummonWorldBossCommand;
import moe.quill.Commands.AdventureCommands.WorldBossCommands.SummonWorldBossDelayedCommand;
import moe.quill.Commands.AdventureCommands.WorldBossCommands.WorldBossTeleportCommand;
import moe.quill.Crafting.CustomCraftingEvents.CraftCustomItemEvent;
import moe.quill.Crafting.CustomCraftingEvents.GrindCustomWeaponEvent;
import moe.quill.Crafting.CustomItems.Attributes.Attribute;
import moe.quill.Crafting.StratumRecipes.Materials.FragmentRecipes.*;
import moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes.ShardCommonToUncommonRecipe;
import moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes.ShardEpicToLegendary;
import moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes.ShardRareToEpicRecipe;
import moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes.ShardUncommonToRareRecipe;
import moe.quill.Crafting.StratumRecipes.Weapons.Battleaxes.*;
import moe.quill.Crafting.StratumRecipes.Weapons.Daggers.*;
import moe.quill.Crafting.CustomItems.Attributes.ItemAttributes;
import moe.quill.Crafting.CustomItems.EventHandler.HandleAttributeEvents;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.Events.ChatEvents.ChatBadgeEvent;
import moe.quill.Events.DevEvent;
import moe.quill.Events.ChatEvents.InjectChatItemEvent;
import moe.quill.Events.StratumEventManager;
import moe.quill.Adventuring.Loot.LootManager;
import moe.quill.Adventuring.NPCManager.ChatNPC.ChatNPCManager;
import moe.quill.Adventuring.NPCManager.NPCEvents.InteractBlacksmithEvent;
import moe.quill.Adventuring.NPCManager.NPCEvents.InteractCryptologistEvent;
import moe.quill.Adventuring.NPCManager.NPCEvents.NPCTransformWitchCancel;
import moe.quill.Adventuring.NPCManager.NPCManager;
import moe.quill.Utils.Serialization.StratumSerialization;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import moe.quill.Crafting.StratumCraftingManager;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.CustomItems.ItemHelpers.ItemGenerator;
import moe.quill.Events.ItemGenerationEvents.GenerateItemOnMobDeath;
import moe.quill.Events.ToolEvents.DaggerBackstabEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public final class StratumSurvival extends JavaPlugin {
    public static final Random rand = new Random();
    private final StratumCraftingManager craftingManager = new StratumCraftingManager(this);
    private final NPCManager npcManager = new NPCManager(this);
    private static final Logger logger = LoggerFactory.getLogger(StratumSurvival.class.getSimpleName());

    //TODO: Add some class for managing all of our namespaced keys... seriously
    @Override
    public void onEnable() {
        logger.info("Enabled!");
        StratumSerialization.init();

        //Init the item attributes manager
        final var itemAttributes = new ItemAttributes(this);
        final var materialManager = new StratumMaterialManager(this);

        //TODO: Find a better way to do this
        Attribute.setMaterialManager(materialManager);
        final var chatNpcManager = new ChatNPCManager(this);
        final var worldBossManager = new WorldBossManager(this);
        final var commandManager = new StratumCommandManager(this);
        final var eventManager = new StratumEventManager(this);
        final var lootManager = new LootManager(this, materialManager);
        final var itemGenerator = new ItemGenerator(materialManager);
        new ItemLists(materialManager);
        itemAttributes.init(this);
        final var enemyManager = new EnemyManager(this, materialManager);


        //setup dev command
        final var devTool = new DevTool(materialManager, this);

        //Register Events
        eventManager.register(
                new HandleAttributeEvents(),
                new GenerateItemOnMobDeath(itemGenerator),
                new InjectChatItemEvent(),
                new GrindCustomWeaponEvent(materialManager),
                new InteractCryptologistEvent(npcManager),
                new InteractBlacksmithEvent(npcManager, materialManager),
                new CraftCustomItemEvent(itemGenerator, materialManager),
                new NPCTransformWitchCancel(),
                new DaggerBackstabEvent(materialManager),
                new DevEvent(),
                new ChatBadgeEvent(this),
                devTool
        );
        craftingManager.enable(materialManager);

        commandManager.register(
                new StratumCommand("generateitem", new GenerateItem(itemGenerator), new GenerateItemTabs()),
                new StratumCommand("addchatline", new AddChatLineCommand(chatNpcManager), new AddChatLineTabs(chatNpcManager)),
                new StratumCommand("deletechatnpc", new DeleteChatNpcCommand(chatNpcManager), new DeleteChatNpcTabs(chatNpcManager)),
                new StratumCommand("removechatline", new RemoveChatLineCommand(chatNpcManager), new DeleteChatNpcTabs(chatNpcManager)),
                new StratumCommand("removechatlineraw", new RemoveChatLineRawCommand(chatNpcManager), null),
                new StratumCommand("obfuscate", new ObfuscateItem(), null),
                new StratumCommand("deobfuscate", new DeobfuscateItem(), null),
                new StratumCommand("spawnnpc", new SpawnNPCCommand(npcManager), null),
                new StratumCommand("reroll", new RerollItem(), null),
                new StratumCommand("spawnchatnpc", new SpawnChatNpcCommand(chatNpcManager), null),
                new StratumCommand("spawnworldboss", new SummonWorldBossCommand(worldBossManager), null),
                new StratumCommand("spawnworldbossdelayed", new SummonWorldBossDelayedCommand(worldBossManager), null),
                new StratumCommand("worldbosstp", new WorldBossTeleportCommand(worldBossManager), null),
                new StratumCommand("spawnenemy", new SpawnEnemy(enemyManager), new SpawnEnemyTabs()),
                new StratumCommand("devtool", devTool, null)
        );
    }

    @Override
    public void onDisable() {
        logger.warn("Disabled!");
        craftingManager.disable();
    }
}
