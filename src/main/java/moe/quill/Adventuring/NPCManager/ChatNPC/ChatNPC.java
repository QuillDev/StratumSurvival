package moe.quill.Adventuring.NPCManager.ChatNPC;

import moe.quill.StratumSurvival;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;


import java.util.ArrayList;
import java.util.Random;

public class ChatNPC {

    private static final Random rand = StratumSurvival.rand;

    private final Villager villager;
    private final ArrayList<Component> chatLines = new ArrayList<>();
    private final NamespacedKey chatDataKey;
    private final Plugin plugin;
    private int chatEventId = -1;

    public ChatNPC(Villager villager, Plugin plugin, NamespacedKey chatDataKey) {
        this.villager = villager;
        this.plugin = plugin;
        this.chatEventId = startChatting();
        this.chatDataKey = chatDataKey;
        reloadChatLinesFromPersistentData();
    }

    /**
     * Chat the villager line to nearby players
     */
    public void chatNearbyPlayers() {
        if (chatLines.size() == 0) return;
        final var line = chatLines.get(rand.nextInt(chatLines.size()));
        villager.getNearbyEntities(3.5, 3.5, 3.5)
                .stream()
                .filter(entity -> entity instanceof Player)
                .map(entity -> (Player) entity)
                .forEach(player -> player.sendMessage(
                        Component.text(villager.getCustomName())
                                .append(Component.text(":"))
                                .append(Component.space())
                                .append(line)
                ));
    }

    public void removeChatLine(int index) {
        chatLines.remove(index);
        updatePersistentChatData();
    }

    public void addLine(Component component) {
        chatLines.add(component);
        updatePersistentChatData();
    }

    public void reloadChatLinesFromPersistentData() {
        chatLines.clear();
        final var data = villager.getPersistentDataContainer();
        final var chatDataBytes = data.get(chatDataKey, PersistentDataType.BYTE_ARRAY);
        final var deserializedComponentList = StratumSurvival.serializer.deserializeComponentList(chatDataBytes);
        this.chatLines.addAll(deserializedComponentList);
    }

    public void updatePersistentChatData() {
        final var data = villager.getPersistentDataContainer();
        data.set(chatDataKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeComponentList(chatLines));
    }

    public ArrayList<Component> getChatLines() {
        return chatLines;
    }

    public Villager getVillager() {
        return villager;
    }

    public int startChatting() {
        if (this.chatEventId == -1) {
            return this.chatEventId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this::chatNearbyPlayers, 80L, 100L);
        }
        return -1;
    }

    public void stopChatting() {
        Bukkit.getScheduler().cancelTask(this.chatEventId);
        this.chatEventId = -1;
    }
}
