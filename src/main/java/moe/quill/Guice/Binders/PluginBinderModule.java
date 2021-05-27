package moe.quill.Guice.Binders;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import moe.quill.StratumSurvival;

public class PluginBinderModule extends AbstractModule {

    private final StratumSurvival plugin;

    public PluginBinderModule(StratumSurvival plugin) {
        this.plugin = plugin;
    }

    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        this.bind(StratumSurvival.class).toInstance(this.plugin);
    }
}
