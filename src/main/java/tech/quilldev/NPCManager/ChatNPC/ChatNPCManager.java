package tech.quilldev.NPCManager.ChatNPC;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import tech.quilldev.Serialization.StratumSerialization;

import java.util.HashMap;

public class ChatNPCManager {

    private final NamespacedKey chatNpcKey;
    private final HashMap<String, ChatNPC> chatNPCs = new HashMap<>();
    private final Plugin plugin;

    public ChatNPCManager(Plugin plugin) {
        this.chatNpcKey = new NamespacedKey(plugin, "npc_chatter");
        this.plugin = plugin;
        this.loadExistingVillagers();
    }

    public ChatNPC getNpcFromName(String string) {
        return chatNPCs.get(string);
    }

    public void addLineFromName(String name, Component line) {
        final var npc = chatNPCs.get(name);
        if (npc == null) return;
        npc.addLine(line);
    }

    public void spawnNPC(String name, Location location) {
        final var npc = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        final var npcData = npc.getPersistentDataContainer();
        npcData.set(chatNpcKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
        npc.setInvulnerable(true);
        npc.setCustomName(name);
        npc.setPersistent(true);
        npc.setAI(false);
        chatNPCs.putIfAbsent(npc.getCustomName(), new ChatNPC(npc, plugin));
    }

    private void loadExistingVillagers() {
        Bukkit
                .getWorlds()
                .forEach(world -> {
                    world.getEntities()
                            .forEach(entity -> {
                                if (!(entity instanceof Villager)) return;
                                final var npc = (Villager) entity;
                                final var persistentData = npc.getPersistentDataContainer();
                                if (persistentData.getKeys().size() == 0) return;
                                if (!persistentData.has(chatNpcKey, PersistentDataType.BYTE_ARRAY)) return;
                                chatNPCs.putIfAbsent(npc.getCustomName(), new ChatNPC(npc, plugin));
                            });
                });
    }

}
