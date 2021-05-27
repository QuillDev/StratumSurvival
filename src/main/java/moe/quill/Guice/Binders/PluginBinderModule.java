package moe.quill.Guice.Binders;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import moe.quill.StratumSurvival;

public class PluginBinderModule extends AbstractModule {

    private final StratumSurvival plugin;
    private final KeyManager keyManager;
    private final MaterialManager materialManager;

    public PluginBinderModule(StratumSurvival plugin) {
        this.plugin = plugin;
        this.keyManager = new KeyManager(plugin);
        this.materialManager = new MaterialManager(plugin, keyManager);
    }

    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        this.bind(StratumSurvival.class).toInstance(this.plugin);
        this.bind(KeyManager.class).toInstance(this.keyManager);
        this.bind(MaterialManager.class).toInstance(this.materialManager);
    }
}
