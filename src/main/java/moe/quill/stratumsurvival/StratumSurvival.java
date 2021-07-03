package moe.quill.stratumsurvival;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import moe.quill.StratumCommonApi.Annotations.IgnoreDynamicLoading;
import moe.quill.StratumCommonApi.Annotations.Keyable;
import moe.quill.stratumcommonutils.Commands.StratumCommand;
import moe.quill.stratumcommonutils.Plugin.Configuration.StratumConfigBuilder;
import moe.quill.stratumcommonutils.Plugin.StratumPlugin;
import moe.quill.stratumcommonutils.Utils.PackageUtils;
import moe.quill.stratumsurvival.Adventuring.Loot.LootListener;
import moe.quill.stratumsurvival.Adventuring.NPCs.InteractBlacksmithEvent;
import moe.quill.stratumsurvival.Adventuring.NPCs.InteractCryptologistEvent;
import moe.quill.stratumsurvival.Binders.PluginBinderModule;
import moe.quill.stratumsurvival.Commands.AdventureCommands.WorldBossCommands.SummonWorldBossCommand;
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
import moe.quill.stratumsurvival.Commands.Management.TrinketsCommand;
import moe.quill.stratumsurvival.Commands.Misc.DevTool;
import moe.quill.stratumsurvival.Crafting.CraftingEvents.CraftCustomItemEvent;
import moe.quill.stratumsurvival.Crafting.CraftingEvents.GrindCustomWeaponEvent;
import moe.quill.stratumsurvival.Crafting.Items.EventHandler.HandleAttributeEvents;
import moe.quill.stratumsurvival.Crafting.StratumCraftingManager;
import moe.quill.stratumsurvival.Events.ChatEvents.ChatBadgeEvent;
import moe.quill.stratumsurvival.Events.ChatEvents.InjectChatItemEvent;
import moe.quill.stratumsurvival.Events.DevEvent;
import moe.quill.stratumsurvival.Events.InventoryEvents.StopBlockadeClicks;
import moe.quill.stratumsurvival.Events.ItemGenerationEvents.GenerateItemOnMobDeath;
import moe.quill.stratumsurvival.Events.ToolEvents.DaggerBackstabEvent;
import moe.quill.stratumsurvival.Events.ToolEvents.GrappleHookEvent;
import moe.quill.stratumsurvival.Events.ToolEvents.IcePickClimb;
import moe.quill.stratumsurvival.Events.ToolEvents.TrinketBag.TrinketBagEventHandler;
import org.bukkit.NamespacedKey;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@Singleton
public final class StratumSurvival extends StratumPlugin {
    public static final Random rand = new Random();
    private static final Logger logger = LoggerFactory.getLogger(StratumSurvival.class.getSimpleName());

    //Inject all of our events
    @Inject
    StratumCraftingManager craftingManager;
    @Inject
    HandleAttributeEvents handleAttributeEvents;
    @Inject
    GenerateItemOnMobDeath generateItemOnMobDeath;
    @Inject
    InjectChatItemEvent injectChatItemEvent;
    @Inject
    GrindCustomWeaponEvent grindCustomWeaponEvent;
    @Inject
    InteractCryptologistEvent interactCryptologistEvent;
    @Inject
    InteractBlacksmithEvent interactBlacksmithEvent;
    @Inject
    CraftCustomItemEvent craftCustomItemEvent;
    @Inject
    DaggerBackstabEvent daggerBackstabEvent;
    @Inject
    DevEvent devEvent;
    @Inject
    ChatBadgeEvent chatBadgeEvent;
    @Inject
    IcePickClimb icePickClimb;
    @Inject
    GrappleHookEvent grappleHookEvent;
    @Inject
    StopBlockadeClicks stopBlockadeClicks;
    @Inject
    TrinketBagEventHandler trinketBagEventHandler;
    @Inject
    LootListener lootListener;

    //Commands / Listeners
    @Inject
    GenerateItemCommand generateItemCommand;
    @Inject
    GenerateItemTabs generateItemTabs;
    @Inject
    ObfuscateItem obfuscateItem;
    @Inject
    DeobfuscateItem deobfuscateItem;
    @Inject
    RerollItem rerollItem;
    @Inject
    SummonWorldBossCommand summonWorldBossCommand;
    @Inject
    WorldBossTeleportCommand worldBossTeleportCommand;
    @Inject
    SpawnEnemy spawnEnemy;
    @Inject
    SpawnEnemyTabs spawnEnemyTabs;
    @Inject
    GiveStratumItemCommand giveStratumItemCommand;
    @Inject
    GiveStratumItemTabs giveStratumItemTabs;
    @Inject
    ListKeysCommand listKeysCommand;
    @Inject
    TrinketsCommand trinketsCommand;
    @Inject
    DevTool devTool;


    public StratumSurvival() {
        super(
                new StratumConfigBuilder()
                        .setUseKeyManager(true)
                        .setUseSerialization(true)
                        .build()
        );
    }

    @Override
    public void onEnable() {
        super.onEnable();
        final var keyManager = getKeyManager();
        final var name = PackageUtils.getReflectivePackageName(this.getClass());
        final var reflections = new Reflections(name);

        //TODO: Add this to the super implementation maybe... common use case in multiple projects
        final var keyableClasses = reflections.getTypesAnnotatedWith(Keyable.class);

        //Iterate through the keyable classes we found
        for (final var keyableClass : keyableClasses) {
            //If the class wants to skip dynamic loading, skip it
            if (keyableClass.isAnnotationPresent(IgnoreDynamicLoading.class)) continue;

            //Iterate through the enum keys and create keys for them
            final var enumKeys = (Enum<?>[]) keyableClass.getEnumConstants();
            for (final var enumKey : enumKeys) {
                keyManager.getKeyMap().put(enumKey.name(), new NamespacedKey(this, enumKey.name()));
            }
        }

        //DI STUFF
        Injector injector = Guice.createInjector(
                new PluginBinderModule(this, keyManager, getSerializer(), reflections)
        );
        injector.injectMembers(this);

        //Load recipes from the crafting manager
        craftingManager.loadRecipesDynamically();

        registerEvent(
                handleAttributeEvents,
                generateItemOnMobDeath,
                injectChatItemEvent,
                grindCustomWeaponEvent,
                interactBlacksmithEvent,
                interactCryptologistEvent,
                craftCustomItemEvent,
                daggerBackstabEvent,
                devEvent,
                chatBadgeEvent,
                icePickClimb,
                grappleHookEvent,
                trinketBagEventHandler,
                lootListener,
                stopBlockadeClicks
        );


        registerCommand(
                new StratumCommand("generateitem", generateItemCommand, generateItemTabs),
                new StratumCommand("obfuscate", obfuscateItem, null),
                new StratumCommand("deobfuscate", deobfuscateItem, null),
                new StratumCommand("reroll", rerollItem, null),
                new StratumCommand("spawnworldboss", summonWorldBossCommand, null),
                new StratumCommand("spawnworldbossdelayed", summonWorldBossCommand, null),
                new StratumCommand("worldbosstp", worldBossTeleportCommand, null),
                new StratumCommand("spawnenemy", spawnEnemy, spawnEnemyTabs),
                new StratumCommand("devtool", devTool, null),
                new StratumCommand("stratumgive", giveStratumItemCommand, giveStratumItemTabs),
                new StratumCommand("listkeys", listKeysCommand, null),
                new StratumCommand("trinkets", trinketsCommand, null)
        );
    }

    @Override
    public void onDisable() {
        super.onDisable();

        //if the crafting manager is not null, just return out
        if (craftingManager != null) {
            craftingManager.disable();
        }

    }
}
