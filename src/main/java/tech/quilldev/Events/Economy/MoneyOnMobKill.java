package tech.quilldev.Events.Economy;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MoneyOnMobKill implements Listener {

    private final Economy economy;

    public MoneyOnMobKill(Economy economy) {
        this.economy = economy;
    }

    @EventHandler
    public void onMobKill(EntityDeathEvent event) {
        final var entity = event.getEntity();
        final var player = entity.getKiller();
        if (player == null) return;
        economy.depositPlayer(player, 25);
    }
}
