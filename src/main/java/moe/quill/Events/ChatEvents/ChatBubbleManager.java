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

    public ChatBubbleManager(Plugin plugin, Player player) {
        this.messageList = new ArrayList<>();
        this.player = player;
        this.plugin = plugin;
    }

    //TODO: FIX, INCONSISTENT
    public void addMessage(Component component) {
        final var timeRemaining = (messageList.size() == 0) ?
                0L
                : Bukkit.getCurrentTick() - messageList.get(0).startTicks + ((messageList.size() - 1) * 20 * 4L);

        final var data = new ChatCloudData(component, Bukkit.getCurrentTick() + timeRemaining);
        messageList.add(data);

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            summonChatTag(player, component);
        }, timeRemaining);

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            messageList.remove(data);
        }, timeRemaining + 20 * 4);

    }

    private void summonChatTag(Player player, Component message) {
        final var nameTag = (AreaEffectCloud) player.getWorld().spawnEntity(player.getLocation(), EntityType.AREA_EFFECT_CLOUD);
        nameTag.setParticle(Particle.TOWN_AURA);
        nameTag.setRadius(0.0F);
        player.addPassenger(nameTag);
        nameTag.customName(message);
        nameTag.setCustomNameVisible(true);
        nameTag.setWaitTime(0);
        nameTag.setDuration(20 * 4);
    }
}
