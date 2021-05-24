package moe.quill.Adventuring.NPCManager;

import moe.quill.Adventuring.NPCManager.NPCs.Blacksmith;
import moe.quill.Adventuring.NPCManager.NPCs.Cryptologist;
import moe.quill.Adventuring.NPCManager.NPCs.NPC;
import moe.quill.Adventuring.NPCManager.NPCs.NPCType;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

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