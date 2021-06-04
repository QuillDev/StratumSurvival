package moe.quill.stratumsurvival.Adventuring.Bosses;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Adventuring.Bosses.BossAttacks.BossAttack;
import moe.quill.stratumsurvival.Adventuring.Bosses.BossAttacks.FlingVerticallyAttack;
import moe.quill.stratumsurvival.Adventuring.Bosses.BossAttacks.LevitatePlayersAttack;
import moe.quill.stratumsurvival.Adventuring.Bosses.BossAttacks.SpawnZombiesAttack;
import moe.quill.stratumsurvival.StratumSurvival;
import moe.quill.stratumsurvival.Utils.TickHelper;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@Singleton
public class WorldBossManager {

    //TODO: Rework this class a bit when we come back to it
    private final Plugin plugin;

    private final BukkitScheduler scheduler;
    private final NamespacedKey worldBossKey;
    private final ISerializer serializer;

    //World that we handle world bosses in
    private final World world = Bukkit.getWorld("worldbossworld");

    //ID of the de spawning event
    private int despawnWorldBossId = -1;
    //HP Bar for the world boss
    private final BossBar bossBar;
    private boolean activeBattle = false;
    int combatantSize = 0;

    //Stats during the fight
    private final HashMap<Player, Integer> dpsMap = new HashMap<>();

    //Boss attack scheduling id
    private int bossAttackScheduleId = -1;
    //Add attacks to the boss
    private final ArrayList<BossAttack> bossAttacks = new ArrayList<>(Arrays.asList(
            new SpawnZombiesAttack(),
            new LevitatePlayersAttack(),
            new FlingVerticallyAttack()
    ));

    //TODO: Add Support for multiple world bosses at once (some sort of boss data class)
    @Inject
    public WorldBossManager(Plugin plugin, ISerializer serializer) {
        this.plugin = plugin;
        this.worldBossKey = new NamespacedKey(plugin, "mob_world_boss");
        this.bossBar = Bukkit.createBossBar("", BarColor.RED, BarStyle.SOLID);
        this.scheduler = Bukkit.getScheduler();
        this.serializer = serializer;

        //Register the world boss listeners
        plugin.getServer().getPluginManager().registerEvents(new WorldBossListeners(this), plugin);
        startWorldBossSchedule();
    }

    /**
     * Start spawning world bosses with the given delays
     */
    public void startWorldBossSchedule() {
        if (world == null) return;
        final var spawnBlock = world.getBlockAt(3, 41, -56);
        scheduler.scheduleSyncRepeatingTask(plugin,
                () -> spawnWithDelay(spawnBlock.getLocation()),
                TickHelper.THIRTY_MINUTES,
                TickHelper.THIRTY_MINUTES
        );
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

        bossAttackScheduleId = scheduler.scheduleSyncRepeatingTask(plugin, () -> {
            final var attack = bossAttacks.get(StratumSurvival.rand.nextInt(bossAttacks.size()));
            nearbyPlayers.forEach(player -> player.showTitle(Title.title(Component.empty(), attack.getWarningText())));
            attack.execute(boss);
        }, TickHelper.secToTick(5), TickHelper.secToTick(2));

        //Schedule the de spawn task
        despawnWorldBossId = scheduler.scheduleSyncDelayedTask(plugin, () -> {
            boss.remove();
            Bukkit.getServer().sendMessage(
                    Component.text("The boss was not killed in time and returned to it's den.")
                            .color(TextColor.color(0xFF544D))
            );
        }, TickHelper.minToTick(5));
    }

    /**
     * Spawn the boss with a delay
     *
     * @param location to spawn the boss at
     */
    public void spawnWithDelay(Location location) {
        final var ticksTillSpawn = TickHelper.minToTick(1); //1 Minute spawn delay

        announceWorldBossTimer(ticksTillSpawn);

        //Log when there's 30 seconds left
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            announceWorldBossTimer(TickHelper.secToTick(30));
        }, TickHelper.secToTick(30));

        //Log when there's 10 seconds left
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            announceWorldBossTimer(TickHelper.secToTick(10));
        }, TickHelper.secToTick(50));

        //Start onscreen countdown when there's 5 seconds left
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            startNearbyCountdown(location);
        }, ticksTillSpawn - (TickHelper.secToTick(5)));

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

    public int getDespawnWorldBossId() {
        return despawnWorldBossId;
    }

    public int getBossAttackScheduleId() {
        return bossAttackScheduleId;
    }
}
