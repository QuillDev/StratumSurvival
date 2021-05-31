package moe.quill.stratumsurvival.Binders;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
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

    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        this.bind(Plugin.class).toInstance(this.plugin);
        this.bind(IKeyManager.class).toInstance(this.keyManager);
        this.bind(MaterialManager.class).toInstance(this.materialManager);
        this.bind(ItemHelper.class).toInstance(this.itemHelper);
        this.bind(ItemGenerator.class).toInstance(this.itemGenerator);
    }
}
