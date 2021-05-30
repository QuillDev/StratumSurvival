package moe.quill;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import moe.quill.Adventuring.Bosses.WorldBossManager;
import moe.quill.Adventuring.Enemies.EnemyManager;
import moe.quill.Adventuring.Loot.LootListener;
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
import moe.quill.Crafting.Items.ItemHelpers.ItemHelper;
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
import moe.quill.StratumCommon.Serialization.StratumSerializer;
import org.bukkit.plugin.java.JavaPlugin;
import moe.quill.Crafting.StratumCraftingManager;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Items.ItemHelpers.ItemGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@Singleton
public final class StratumSurvival extends JavaPlugin {
    public static final Random rand = new Random();
    private static final Logger logger = LoggerFactory.getLogger(StratumSurvival.class.getSimpleName());
    private final StratumCraftingManager craftingManager = new StratumCraftingManager(this);

    @Inject
    private KeyManager keyManager;
    @Inject
    private MaterialManager materialManager;
    @Inject
    private ItemAttributes itemAttributes;
    @Inject
    private ItemHelper itemHelper;
    @Inject
    private ItemLists itemLists;
    @Inject
    private ItemGenerator itemGenerator;
    @Inject
    private NPCManager npcManager;
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

    public static StratumSerializer serializer;

    @Override
    public void onEnable() {

        try {

            //Get the services manager
            //TODO: Some sort of services manager?
            final var serviceManager = getServer().getServicesManager();
            final var serializeService = serviceManager.getRegistration(StratumSerializer.class);
            if (serializeService == null) {
                logger.error("Could not get the serializer service!");
                throw new Exception("Could not get the serializer service!");
            }
            StratumSurvival.serializer = serializeService.getProvider();


            //DI STUFF
            PluginBinderModule module = new PluginBinderModule(this);
            module.createInjector().injectMembers(this);

            //setup dev command
            final var devTool = new DevTool(materialManager, this);
            //Register Events
            eventManager.register(
                    new HandleAttributeEvents(keyManager),
                    new GenerateItemOnMobDeath(itemGenerator),
                    new InjectChatItemEvent(),
                    new GrindCustomWeaponEvent(keyManager, materialManager),
                    new InteractCryptologistEvent(keyManager, itemHelper, npcManager),
                    new InteractBlacksmithEvent(npcManager, materialManager, keyManager, itemHelper),
                    new CraftCustomItemEvent(keyManager, itemGenerator, materialManager),
                    new NPCTransformWitchCancel(),
                    new DaggerBackstabEvent(keyManager),
                    new DevEvent(),
                    new ChatBadgeEvent(this),
                    new IcePickClimb(keyManager),
                    new GrappleHookEvent(keyManager),
                    new StopBlockadeClicks(materialManager),
                    new TrinketBagEventHandler(keyManager, materialManager),
                    new LootListener(lootManager, keyManager),
                    devTool
            );
            craftingManager.enable(materialManager);

            commandManager.register(
                    new StratumCommand("generateitem", new GenerateItemCommand(itemGenerator), new GenerateItemTabs()),
//                    new StratumCommand("addchatline", new AddChatLineCommand(chatNpcManager), new AddChatLineTabs(chatNpcManager)),
//                    new StratumCommand("deletechatnpc", new DeleteChatNpcCommand(chatNpcManager), new DeleteChatNpcTabs(chatNpcManager)),
//                    new StratumCommand("removechatline", new RemoveChatLineCommand(chatNpcManager), new DeleteChatNpcTabs(chatNpcManager)),
//                    new StratumCommand("removechatlineraw", new RemoveChatLineRawCommand(chatNpcManager), null),
                    new StratumCommand("obfuscate", new ObfuscateItem(itemHelper), null),
                    new StratumCommand("deobfuscate", new DeobfuscateItem(itemHelper), null),
//                    new StratumCommand("spawnnpc", new SpawnNPCCommand(npcManager), null),
                    new StratumCommand("reroll", new RerollItem(itemHelper), null),
//                    new StratumCommand("spawnchatnpc", new SpawnChatNpcCommand(chatNpcManager), null),
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

    public LootTables getLootTables() {
        return lootTables;
    }

    @Override
    public void onDisable() {
        craftingManager.disable();
    }
}
