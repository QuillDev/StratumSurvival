package tech.quilldev.NPCManager;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import tech.quilldev.NPCManager.NPCs.Blacksmith;
import tech.quilldev.NPCManager.NPCs.Cryptologist;
import tech.quilldev.NPCManager.NPCs.NPC;
import tech.quilldev.NPCManager.NPCs.NPCType;

import java.util.ArrayList;
import java.util.Arrays;

public class NPCManager {

    public final ArrayList<NPC> npcs = new ArrayList<>();

    public NPCManager(Plugin plugin) {
        npcs.addAll(
                Arrays.asList(
                        new Cryptologist(new NamespacedKey(plugin, NPCType.CRYPTOLOGIST.key)),
                        new Blacksmith(new NamespacedKey(plugin, NPCType.BLACKSMITH.key))
                )
        );
    }

    /**
     * Get the first NPC type that has the given key
     *
     * @param type the key to search for
     * @return the npc that has the given key
     */
    public NPC getNPCByType(NPCType type) {
        return npcs
                .stream()
                .filter(npc -> npc.getKey().getKey().equalsIgnoreCase(type.key))
                .findFirst()
                .orElse(null);
    }

}
