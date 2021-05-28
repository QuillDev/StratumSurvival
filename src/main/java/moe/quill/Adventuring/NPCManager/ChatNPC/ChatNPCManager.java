package moe.quill.Adventuring.NPCManager.ChatNPC;

import com.google.inject.Inject;
import moe.quill.StratumSurvival;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import moe.quill.Utils.Serialization.StratumSerialization;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatNPCManager {

    //Keep the plugin here for access
    private final Plugin plugin;

    //Villager data keys
    private final NamespacedKey chatNpcKey;
    private final NamespacedKey npcChatDataKey;

    //List of NPCs on the server
    private final HashMap<String, ChatNPC> chatNPCs = new HashMap<>();

    @Inject
    public ChatNPCManager(Plugin plugin) {
        this.chatNpcKey = new NamespacedKey(plugin, "npc_chatter");
        this.npcChatDataKey = new NamespacedKey(plugin, "npc_line_data");
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

    /**
     * Delete the npc with the given name
     *
     * @param name of the entity to delete
     */
    public void delete(String name) {
        final var npc = chatNPCs.get(name);
        npc.getVillager().remove();
        npc.stopChatting();
        chatNPCs.remove(name);

    }

    public void spawnNPC(String name, Location location) {
        final var npc = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        final var npcData = npc.getPersistentDataContainer();
        npcData.set(chatNpcKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
        npcData.set(npcChatDataKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeComponentList(new ArrayList<>()));
        npc.setInvulnerable(true);
        npc.setCustomName(name);
        npc.setPersistent(true);
        npc.setAI(false);
        chatNPCs.putIfAbsent(npc.getCustomName(), new ChatNPC(npc, plugin, npcChatDataKey));
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
                                chatNPCs.putIfAbsent(npc.getCustomName(), new ChatNPC(npc, plugin, npcChatDataKey));
                            });
                });
    }

    public HashMap<String, ChatNPC> getChatNPCs() {
        return chatNPCs;
    }

}
