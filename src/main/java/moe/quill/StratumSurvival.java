package moe.quill;

import com.google.inject.Inject;
import moe.quill.Adventuring.Bosses.WorldBossManager;
import moe.quill.Adventuring.Enemies.EnemyManager;
import moe.quill.Adventuring.Loot.LootTables;
import moe.quill.Commands.EnemyCommands.SpawnEnemyTabs;
import moe.quill.Commands.ItemCommands.GiveStratumItem.GiveStratumItemCommand;
import moe.quill.Commands.ItemCommands.GiveStratumItem.GiveStratumItemTabs;
import moe.quill.Commands.ItemCommands.ListKeysCommand;
import moe.quill.Commands.Misc.DevTool;
import moe.quill.Commands.EnemyCommands.SpawnEnemy;
import moe.quill.Commands.ItemCommands.DeobfuscateItem;
import moe.quill.Commands.ItemCommands.GenerateItem.GenerateItemCommand;
import moe.quill.Commands.ItemCommands.GenerateItem.GenerateItemTabs;
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
import moe.quill.Crafting.CraftingEvents.CraftCustomItemEvent;
import moe.quill.Crafting.CraftingEvents.GrindCustomWeaponEvent;
import moe.quill.Crafting.Items.Attributes.Attribute;
import moe.quill.Crafting.Items.Attributes.ItemAttributes;
import moe.quill.Crafting.Items.EventHandler.HandleAttributeEvents;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.Crafting.KeyManager;
import moe.quill.Events.ChatEvents.ChatBadgeEvent;
import moe.quill.Events.DevEvent;
import moe.quill.Events.ChatEvents.InjectChatItemEvent;
import moe.quill.Events.InventoryEvents.StopBlockadeClicks;
import moe.quill.Events.ItemGenerationEvents.GenerateItemOnMobDeath;
import moe.quill.Events.StratumEventManager;
import moe.quill.Adventuring.Loot.LootManager;
import moe.quill.Adventuring.NPCManager.ChatNPC.ChatNPCManager;
import moe.quill.Adventuring.NPCManager.NPCEvents.InteractBlacksmithEvent;
import moe.quill.Adventuring.NPCManager.NPCEvents.InteractCryptologistEvent;
import moe.quill.Adventuring.NPCManager.NPCEvents.NPCTransformWitchCancel;
import moe.quill.Adventuring.NPCManager.NPCManager;
import moe.quill.Events.ToolEvents.DaggerBackstabEvent;
import moe.quill.Events.ToolEvents.GrappleHookEvent;
import moe.quill.Events.ToolEvents.IcePickClimb;
import moe.quill.Events.ToolEvents.TrinketBag.TrinketBagEventHandler;
import moe.quill.Guice.Binders.PluginBinderModule;
import moe.quill.Utils.Serialization.StratumSerialization;
import org.bukkit.plugin.java.JavaPlugin;
import moe.quill.Crafting.StratumCraftingManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.Items.ItemHelpers.ItemGenerator;

import java.util.Random;

public final class StratumSurvival extends JavaPlugin {
    public static final Random rand = new Random();
    private final StratumCraftingManager craftingManager = new StratumCraftingManager(this);

    @Inject
    private KeyManager keyManager;
    @Inject
    private StratumMaterialManager materialManager;
    @Inject
    private ItemAttributes itemAttributes;
    @Inject
    private ItemGenerator itemGenerator;
    @Inject
    private NPCManager npcManager;
    @Inject
    private ItemLists itemLists;
    @Inject
    private ChatNPCManager chatNpcManager;
    @Inject
    private WorldBossManager worldBossManager;
    @Inject
    private StratumCommandManager commandManager;
    @Inject
    private StratumEventManager eventManager;
    @Inject
    private LootTables lootTables;
    @Inject
    private LootManager lootManager;
    @Inject
    private EnemyManager enemyManager;

    @Override
    public void onEnable() {

        try {
            StratumSerialization.init();

            //DI STUFF
            PluginBinderModule module = new PluginBinderModule(this);
            module.createInjector()
                    .injectMembers(this);

            Attribute.setMaterialManager(materialManager);
            itemAttributes.init();


            //setup dev command
            final var devTool = new DevTool(materialManager, this);

            //Register Events
            eventManager.register(
                    new HandleAttributeEvents(keyManager),
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
                    new IcePickClimb(materialManager),
                    new GrappleHookEvent(materialManager),
                    new StopBlockadeClicks(materialManager),
                    new TrinketBagEventHandler(materialManager),
                    devTool
            );
            craftingManager.enable(materialManager);

            commandManager.register(
                    new StratumCommand("generateitem", new GenerateItemCommand(itemGenerator), new GenerateItemTabs()),
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
                    new StratumCommand("devtool", devTool, null),
                    new StratumCommand("stratumgive", new GiveStratumItemCommand(materialManager), new GiveStratumItemTabs(materialManager)),
                    new StratumCommand("listkeys", new ListKeysCommand(), null)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public StratumMaterialManager getMaterialManager() {
        return materialManager;//TODO FIX
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public LootTables getLootTables() {
        return lootTables;
    }

    @Override
    public void onDisable() {
        craftingManager.disable();
    }
}
