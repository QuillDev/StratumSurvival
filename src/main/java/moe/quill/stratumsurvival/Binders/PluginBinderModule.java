package moe.quill.stratumsurvival.Binders;

import com.google.inject.AbstractModule;
import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumcommonutils.Plugin.StratumPlugin;
import moe.quill.stratumsurvival.Adventuring.Bosses.WorldBossManager;
import moe.quill.stratumsurvival.Adventuring.Enemies.EnemyManager;
import moe.quill.stratumsurvival.Adventuring.Loot.LootManager;
import moe.quill.stratumsurvival.Adventuring.Loot.LootTables;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.ItemAttributes;
import moe.quill.stratumsurvival.Crafting.Items.ItemHelpers.ItemGenerator;
import moe.quill.stratumsurvival.Crafting.Items.ItemHelpers.ItemHelper;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.stratumsurvival.Crafting.StratumCraftingManager;
import org.bukkit.plugin.Plugin;

public class PluginBinderModule extends AbstractModule {

    private final Plugin plugin;
    private final IKeyManager keyManager;
    private final MaterialManager materialManager;
    private final ItemHelper itemHelper;
    private final ItemGenerator itemGenerator;
    private final WorldBossManager worldBossManager;
    private final StratumCraftingManager craftingManager;
    private final ItemAttributes itemAttributes;
    private final LootTables lootTables;
    private final LootManager lootManager;
    private final EnemyManager enemyManager;
    private final ISerializer serializer;
    private final ItemLists itemLists;

    public PluginBinderModule(StratumPlugin plugin, IKeyManager keyManager, ISerializer serializer) {
        this.plugin = plugin;
        this.serializer = serializer;
        this.keyManager = keyManager;
        this.worldBossManager = new WorldBossManager(plugin, serializer);
        this.itemHelper = new ItemHelper(keyManager, serializer);
        this.materialManager = new MaterialManager(plugin, keyManager, serializer);
        this.itemLists = new ItemLists(materialManager);
        this.itemAttributes = new ItemAttributes(plugin, materialManager, keyManager, serializer, itemLists);
        this.craftingManager = new StratumCraftingManager(plugin, materialManager);
        this.lootTables = new LootTables(materialManager);
        this.enemyManager = new EnemyManager(materialManager);
        this.itemGenerator = new ItemGenerator(keyManager, itemHelper, itemAttributes, serializer);
        this.lootManager = new LootManager(keyManager, materialManager, lootTables, serializer);

    }

    @Override
    protected void configure() {
        bind(Plugin.class).toInstance(plugin);
        bind(IKeyManager.class).toInstance(keyManager);
        bind(MaterialManager.class).toInstance(materialManager);
        bind(ItemHelper.class).toInstance(itemHelper);
        bind(ItemGenerator.class).toInstance(itemGenerator);
        bind(WorldBossManager.class).toInstance(worldBossManager);
        bind(LootTables.class).toInstance(lootTables);
        bind(LootManager.class).toInstance(lootManager);
        bind(ISerializer.class).toInstance(serializer);
        bind(EnemyManager.class).toInstance(enemyManager);
        bind(StratumCraftingManager.class).toInstance(craftingManager);
        bind(ItemAttributes.class).toInstance(itemAttributes);
        bind(ItemLists.class).toInstance(itemLists);
    }
}
