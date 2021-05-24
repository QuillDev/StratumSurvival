package moe.quill.Events.ChatEvents;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class ChatBubbleManager {

    private final ArrayList<ChatCloudData> messageList;
    private final Player player;
    private final Plugin plugin;
    private static final long DELAY = 50L;

    public ChatBubbleManager(Plugin plugin, Player player) {
        this.messageList = new ArrayList<>();
        this.player = player;
        this.plugin = plugin;
    }

    /**
     * Add a message to be scheduled as a chat over head
     *
     * @param component to show over the players head
     */
    public void addMessage(Component component) {

        //Calculate the remaining time till this message should play
        final var timeRemaining = (messageList.size() == 0) ?
                0L
                : (messageList.get(messageList.size() - 1).startTicks + DELAY) - Bukkit.getCurrentTick();

        //Create the chat box information for when to schedule the event etc
        final var data = new ChatCloudData(component, Bukkit.getCurrentTick() + timeRemaining);
        messageList.add(data);

        //Schedule the task for the estimated tie
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            summonChatTag(player, component);

            // Schedule the cleanup task for the chat bubble
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                messageList.remove(data);
            }, DELAY);
        }, timeRemaining);


    }

    /**
     * Summon a chat tag above the player @ the given location
     *
     * @param player  to spawn the chat tag on
     * @param message to put on the tag
     */
    private void summonChatTag(Player player, Component message) {
        final var nameTag = (AreaEffectCloud) player.getWorld().spawnEntity(player.getLocation(), EntityType.AREA_EFFECT_CLOUD);
        nameTag.setParticle(Particle.TOWN_AURA);
        nameTag.setRadius(0.0F);
        player.addPassenger(nameTag);
        nameTag.customName(message);
        nameTag.setCustomNameVisible(true);
        nameTag.setWaitTime(0);
        nameTag.setDuration((int) DELAY);
    }
}
