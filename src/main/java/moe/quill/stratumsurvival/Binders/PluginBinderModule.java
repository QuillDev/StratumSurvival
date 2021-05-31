package moe.quill.stratumsurvival.Binders;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.stratumsurvival.Crafting.Items.ItemHelpers.ItemGenerator;
import moe.quill.stratumsurvival.Crafting.Items.ItemHelpers.ItemHelper;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import org.bukkit.plugin.Plugin;

public class PluginBinderModule extends AbstractModule {

    private final Plugin plugin;
    private final IKeyManager keyManager;
    private final MaterialManager materialManager;
    private final ItemHelper itemHelper;
    private final ItemGenerator itemGenerator;

    public PluginBinderModule(Plugin plugin, IKeyManager keyManager) {
        this.plugin = plugin;
        this.keyManager = keyManager;
        this.materialManager = new MaterialManager(plugin, keyManager);
        this.itemHelper = new ItemHelper(keyManager);
        this.itemGenerator = new ItemGenerator(keyManager, itemHelper);
    }

    @Override
    protected void configure() {
        bind(Plugin.class).toInstance(plugin);
        bind(IKeyManager.class).toInstance(keyManager);
        bind(MaterialManager.class).toInstance(materialManager);
        bind(ItemHelper.class).toInstance(itemHelper);
        bind(ItemGenerator.class).toInstance(itemGenerator);
    }
}
