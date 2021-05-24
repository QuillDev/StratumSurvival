package moe.quill.Bosses;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import moe.quill.Serialization.StratumSerialization;

import java.util.Collection;
import java.util.HashMap;

public class WorldBossManager {

    private final Plugin plugin;

    //TODO: Another manager class pls
    private final BukkitScheduler scheduler;
    private final NamespacedKey worldBossKey;

    //World that we handle world bosses in
    private final World world = Bukkit.getWorld("worldbossworld");

    //HP Bar for the world boss
    private final BossBar bossBar;
    private boolean activeBattle = false;
    int combatantSize = 0;

    //Stats during the fight
    private final HashMap<Player, Integer> dpsMap = new HashMap<>();

    //TODO: Add Support for multiple world bosses at once (some sort of boss data class)
    public WorldBossManager(Plugin plugin) {
        this.plugin = plugin;
        this.worldBossKey = new NamespacedKey(plugin, "mob_world_boss");
        this.bossBar = Bukkit.createBossBar("", BarColor.RED, BarStyle.SOLID);
        this.scheduler = Bukkit.getScheduler();
        //Register the world boss listeners
        plugin.getServer().getPluginManager().registerEvents(new WorldBossListeners(this), plugin);
    }

    /**
     * Summon a world boss with scaling HP at the given location
     *
     * @param location to spawn the boss at
     */
    public void spawnWorldBoss(Location location) {
        if (activeBattle) return; //If there is an active battle don't spawn the boss
        //Check nearby players to the given location
        final var nearbyPlayers = location.getNearbyPlayers(50, 50, 50);

        //If there are no nearby players, don't spawn the boss
        if (nearbyPlayers.size() == 0) {
            this.activeBattle = false;
            Bukkit.getServer().sendMessage(
                    Component.text("No combatants arrived to face the boss, it returns to it's den.")
                            .color(TextColor.color(0xFF544D))
            );
            return;
        }
        //Setup properties of the world boss scaling based on nearby players
        final var boss = (Giant) location.getWorld().spawnEntity(location, EntityType.GIANT);
        final var bossData = boss.getPersistentDataContainer();
        bossData.set(worldBossKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
        this.combatantSize = nearbyPlayers.size();
        boss.setHealth(20f * combatantSize);

        //Setup the boss bar
        nearbyPlayers.forEach(bossBar::addPlayer);
        bossBar.setProgress(1f); //star the progress at the max

        //World boss state data
        this.activeBattle = true; //say that the battle started

        //Log that the world boss has spawned
        Bukkit.getServer().sendMessage(
                Component.text("A world boss has been summoned!")
                        .color(TextColor.color(0xFF544D))
        );
    }

    /**
     * Spawn the boss with a delay
     *
     * @param location to spawn the boss at
     */
    public void spawnWithDelay(Location location) {
        final var ticksTillSpawn = 20 * 60; //1 Minute spawn delay

        announceWorldBossTimer(ticksTillSpawn);

        //Log when there's 30 seconds left
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            announceWorldBossTimer(30 * 20);
        }, 30 * 20);

        //Log when there's 10 seconds left
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            announceWorldBossTimer(10 * 20);
        }, 50 * 20);

        //Start onscreen countdown when there's 5 seconds left
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            startNearbyCountdown(location);
        }, ticksTillSpawn - (20 * 5));

        //Spawn the world boss after the ticks are up
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            spawnWorldBoss(location);
        }, ticksTillSpawn);
    }

    /**
     * Start the nearby countdown for players close to the boss
     *
     * @param location to ger players at
     */
    public void startNearbyCountdown(Location location) {
        final var nearbyPlayers = location.getNearbyPlayers(50, 50, 50);
        scheduler.scheduleSyncDelayedTask(plugin, () -> showCountdownText(nearbyPlayers, 5, TextColor.color(0x86F95C)), 0L);
        scheduler.scheduleSyncDelayedTask(plugin, () -> showCountdownText(nearbyPlayers, 4, TextColor.color(0xF9D054)), 20L);
        scheduler.scheduleSyncDelayedTask(plugin, () -> showCountdownText(nearbyPlayers, 3, TextColor.color(0xF99748)), 40L);
        scheduler.scheduleSyncDelayedTask(plugin, () -> showCountdownText(nearbyPlayers, 2, TextColor.color(0xF96334)), 60L);
        scheduler.scheduleSyncDelayedTask(plugin, () -> showCountdownText(nearbyPlayers, 1, TextColor.color(0xF93A30)), 80L);
    }

    public void showCountdownText(Collection<Player> players, int time, TextColor color) {
        //Show the title to each player
        players.forEach(player ->
                player.showTitle(Title.title(Component.text(time).color(color), Component.empty()))
        );
    }

    /**
     * Announce how long there is until the next world boss spawn
     *
     * @param ticks until the next spawn
     */
    public void announceWorldBossTimer(long ticks) {
        Bukkit.getServer().sendMessage(
                Component.text("A world boss will spawn in")
                        .append(Component.space())
                        .append(Component.text(ticks / 20))
                        .append(Component.text("s"))
                        .clickEvent(ClickEvent.clickEvent(ClickEvent.Action.RUN_COMMAND, "/worldbosstp"))
                        .color(TextColor.color(0xFF544D))
        );
    }

    public BossBar getBossBar() {
        return bossBar;
    }

    public NamespacedKey getWorldBossKey() {
        return worldBossKey;
    }

    public int getCombatantSize() {
        return combatantSize;
    }

    public HashMap<Player, Integer> getDpsMap() {
        return dpsMap;
    }

    public void setActiveBattle(boolean activeBattle) {
        this.activeBattle = activeBattle;
    }

    public World getWorld() {
        return world;
    }
}
