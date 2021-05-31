package moe.quill.Events.ChatEvents;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class ChatBadgeEvent implements Listener {

    private final Plugin plugin;

    public ChatBadgeEvent(Plugin plugin) {
        this.plugin = plugin;
    }

    private HashMap<Player, ChatBubbleManager> chatQueues = new HashMap<>();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerTextOnChatEvent(AsyncChatEvent event) {

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            final var player = event.getPlayer();
            final var message = event.message();

            //if the player is not already cached, add them
            if (!chatQueues.containsKey(player)) {
                chatQueues.put(player, new ChatBubbleManager(plugin, player));
            }
            final var queue = chatQueues.get(player);
            queue.addMessage(message);
        });


    }
}
