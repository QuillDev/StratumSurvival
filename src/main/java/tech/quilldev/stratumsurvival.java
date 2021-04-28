package tech.quilldev;

import org.bukkit.plugin.java.JavaPlugin;
import tech.quilldev.Commands.RTP;

import java.util.Objects;

public final class stratumsurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(this.getCommand("rtp")).setExecutor(new RTP());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
