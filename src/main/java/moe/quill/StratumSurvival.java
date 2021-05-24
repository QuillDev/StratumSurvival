package moe.quill;

import moe.quill.Bosses.WorldBossManager;
import moe.quill.Commands.DevTool;
import moe.quill.Commands.EnemyCommands.SpawnEnemy;
import moe.quill.Commands.ItemGenerator.DeobfuscateItem;
import moe.quill.Commands.ItemGenerator.GenerateItem;
import moe.quill.Commands.ItemGenerator.GenerateItemTabs;
import moe.quill.Commands.ItemGenerator.ObfuscateItem;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.AddChatLines.AddChatLineCommand;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.AddChatLines.AddChatLineTabs;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.DeleteChatNpc.DeleteChatNpcCommand;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.DeleteChatNpc.DeleteChatNpcTabs;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.RemoveChatLine.RemoveChatLineCommand;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.RemoveChatLine.RemoveChatLineRawCommand;
import moe.quill.Commands.NPCCommands.ChatNPCCommands.SpawnChatNpcCommand;
import moe.quill.Commands.NPCCommands.SpawnNPCCommand;
import moe.quill.Commands.RerollItem;
import moe.quill.Commands.StratumCommand;
import moe.quill.Commands.StratumCommandManager;
import moe.quill.Commands.WorldBossCommands.SummonWorldBossCommand;
import moe.quill.Commands.WorldBossCommands.SummonWorldBossDelayedCommand;
import moe.quill.Commands.WorldBossCommands.WorldBossTeleportCommand;
import moe.quill.Crafting.CustomCraftingEvents.CraftCustomItemEvent;
import moe.quill.Crafting.CustomCraftingEvents.GrindCustomWeaponEvent;
import moe.quill.Crafting.StratumRecipes.Materials.FragmentRecipes.*;
import moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes.ShardCommonToUncommonRecipe;
import moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes.ShardEpicToLegendary;
import moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes.ShardRareToEpicRecipe;
import moe.quill.Crafting.StratumRecipes.Materials.ShardRecipes.ShardUncommonToRareRecipe;
import moe.quill.Crafting.StratumRecipes.Weapons.Battleaxes.*;
import moe.quill.Crafting.StratumRecipes.Weapons.Daggers.*;
import moe.quill.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes.BluntWeaponChainAttribute;
import moe.quill.CustomItems.Attributes.ItemAttributes;
import moe.quill.CustomItems.EventHandler.HandleAttributeEvents;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.WeaponHelpers.WeaponLists;
import moe.quill.Events.ChatEvents.InjectChatItemEvent;
import moe.quill.Events.StratumEventManager;
import moe.quill.NPCManager.ChatNPC.ChatNPCManager;
import moe.quill.NPCManager.NPCEvents.InteractBlacksmithEvent;
import moe.quill.NPCManager.NPCEvents.InteractCryptologistEvent;
import moe.quill.NPCManager.NPCEvents.NPCTransformWitchCancel;
import moe.quill.NPCManager.NPCManager;
import moe.quill.Serialization.StratumSerialization;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import moe.quill.Crafting.StratumCraftingManager;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.CustomItems.ItemHelpers.ItemGenerator;
import moe.quill.Events.ItemGenerationEvents.GenerateItemOnMobDeath;
import moe.quill.Events.TestEvents.DaggerBackstabEvent;
import moe.quill.Events.ToolEvents.ToolBreakBlockDropShard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class StratumSurvival extends JavaPlugin {
    private final StratumCraftingManager craftingManager = new StratumCraftingManager(this);
    private final NPCManager npcManager = new NPCManager(this);
    private static final Logger logger = LoggerFactory.getLogger(StratumSurvival.class.getSimpleName());

    @Override
    public void onEnable() {
        logger.info("Enabled!");
        StratumSerialization.init();

        //Init the item attributes manager
        final var itemAttributes = new ItemAttributes(this);
        final var materialManager = new StratumMaterialManager(this);
        final var chatNpcManager = new ChatNPCManager(this);
        final var worldBossManager = new WorldBossManager(this);
        final var commandManager = new StratumCommandManager(this);
        final var eventManager = new StratumEventManager(this);
        final var itemGenerator = new ItemGenerator(materialManager);
        new WeaponLists(materialManager);
        itemAttributes.init(this);

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
                new ToolBreakBlockDropShard(materialManager),
                devTool
        );

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
                new StratumCommand("summonworldbossdelayed", new SummonWorldBossDelayedCommand(worldBossManager), null),
                new StratumCommand("worldbosstp", new WorldBossTeleportCommand(worldBossManager), null),
                new StratumCommand("spawnenemy", new SpawnEnemy(materialManager), null),
                new StratumCommand("devtool", devTool, null)
        );


        //Register recipes from the crafting recipe
        craftingManager.registerDynamicRecipes(materialManager);

    }

    @Override
    public void onDisable() {
        logger.warn("Disabled!");
        craftingManager.disable();
    }
}
