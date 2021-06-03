package moe.quill.stratumsurvival;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Plugin.StratumConfig;
import moe.quill.StratumCommon.Plugin.StratumConfigBuilder;
import moe.quill.StratumCommon.Plugin.StratumPlugin;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Adventuring.Bosses.WorldBossManager;
import moe.quill.stratumsurvival.Adventuring.Enemies.EnemyManager;
import moe.quill.stratumsurvival.Adventuring.Loot.LootListener;
import moe.quill.stratumsurvival.Adventuring.Loot.LootManager;
import moe.quill.stratumsurvival.Adventuring.Loot.LootTables;
import moe.quill.stratumsurvival.Adventuring.NPCManager.ChatNPC.ChatNPCManager;
import moe.quill.stratumsurvival.Adventuring.NPCManager.NPCEvents.InteractBlacksmithEvent;
import moe.quill.stratumsurvival.Adventuring.NPCManager.NPCEvents.InteractCryptologistEvent;
import moe.quill.stratumsurvival.Adventuring.NPCManager.NPCEvents.NPCTransformWitchCancel;
import moe.quill.stratumsurvival.Adventuring.NPCManager.NPCManager;
import moe.quill.stratumsurvival.Binders.PluginBinderModule;
import moe.quill.stratumsurvival.Commands.AdventureCommands.WorldBossCommands.SummonWorldBossCommand;
import moe.quill.stratumsurvival.Commands.AdventureCommands.WorldBossCommands.SummonWorldBossDelayedCommand;
import moe.quill.stratumsurvival.Commands.AdventureCommands.WorldBossCommands.WorldBossTeleportCommand;
import moe.quill.stratumsurvival.Commands.EnemyCommands.SpawnEnemy;
import moe.quill.stratumsurvival.Commands.EnemyCommands.SpawnEnemyTabs;
import moe.quill.stratumsurvival.Commands.ItemCommands.DeobfuscateItem;
import moe.quill.stratumsurvival.Commands.ItemCommands.GenerateItem.GenerateItemCommand;
import moe.quill.stratumsurvival.Commands.ItemCommands.GenerateItem.GenerateItemTabs;
import moe.quill.stratumsurvival.Commands.ItemCommands.GiveStratumItem.GiveStratumItemCommand;
import moe.quill.stratumsurvival.Commands.ItemCommands.GiveStratumItem.GiveStratumItemTabs;
import moe.quill.stratumsurvival.Commands.ItemCommands.ListKeysCommand;
import moe.quill.stratumsurvival.Commands.ItemCommands.ObfuscateItem;
import moe.quill.stratumsurvival.Commands.ItemCommands.RerollItem;
import moe.quill.stratumsurvival.Commands.Misc.DevTool;
import moe.quill.stratumsurvival.Commands.StratumCommand;
import moe.quill.stratumsurvival.Commands.StratumCommandManager;
import moe.quill.stratumsurvival.Crafting.CraftingEvents.CraftCustomItemEvent;
import moe.quill.stratumsurvival.Crafting.CraftingEvents.GrindCustomWeaponEvent;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.ItemAttributes;
import moe.quill.stratumsurvival.Crafting.Items.EventHandler.HandleAttributeEvents;
import moe.quill.stratumsurvival.Crafting.Items.ItemHelpers.ItemGenerator;
import moe.quill.stratumsurvival.Crafting.Items.ItemHelpers.ItemHelper;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.stratumsurvival.Crafting.StratumCraftingManager;
import moe.quill.stratumsurvival.Events.ChatEvents.ChatBadgeEvent;
import moe.quill.stratumsurvival.Events.ChatEvents.InjectChatItemEvent;
import moe.quill.stratumsurvival.Events.DevEvent;
import moe.quill.stratumsurvival.Events.InventoryEvents.StopBlockadeClicks;
import moe.quill.stratumsurvival.Events.ItemGenerationEvents.GenerateItemOnMobDeath;
import moe.quill.stratumsurvival.Events.StratumEventManager;
import moe.quill.stratumsurvival.Events.ToolEvents.DaggerBackstabEvent;
import moe.quill.stratumsurvival.Events.ToolEvents.GrappleHookEvent;
import moe.quill.stratumsurvival.Events.ToolEvents.IcePickClimb;
import moe.quill.stratumsurvival.Events.ToolEvents.TrinketBag.TrinketBagEventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@Singleton
public final class StratumSurvival extends StratumPlugin {
    public static final Random rand = new Random();
    private static final Logger logger = LoggerFactory.getLogger(StratumSurvival.class.getSimpleName());
    private final StratumCraftingManager craftingManager = new StratumCraftingManager(this);

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

    public static ISerializer serializer;

    public StratumSurvival() {
        super(
                new StratumConfigBuilder()
                        .setUseKeyManager(true)
                        .build()
        );
    }

    @Override
    public void onEnable() {
        super.onEnable();
        try {
            //Get the services manager
            final var serviceManager = getServer().getServicesManager();
            final var serializeService = serviceManager.getRegistration(ISerializer.class);
            if (serializeService == null) {
                logger.error("Could not get the serializer service!");
                throw new Exception("Could not get the serializer service!");
            }

            StratumSurvival.serializer = serializeService.getProvider();
            final var keyManager = getKeyManager();
            keyManager.loadKeyablesDynamically(this);

            //DI STUFF
            Injector injector = Guice.createInjector(
                    new PluginBinderModule(this, keyManager)
            );
            injector.injectMembers(this);

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
                    new StratumCommand("obfuscate", new ObfuscateItem(itemHelper), null),
                    new StratumCommand("deobfuscate", new DeobfuscateItem(itemHelper), null),
                    new StratumCommand("reroll", new RerollItem(itemHelper), null),
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
        super.onDisable();
        craftingManager.disable();
    }
}
