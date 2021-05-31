package moe.quill.stratumsurvival.Adventuring.NPCManager;

import moe.quill.stratumsurvival.Adventuring.NPCManager.NPCs.Blacksmith;
import moe.quill.stratumsurvival.Adventuring.NPCManager.NPCs.Cryptologist;
import moe.quill.stratumsurvival.Adventuring.NPCManager.NPCs.NPC;
import moe.quill.stratumsurvival.Adventuring.NPCManager.NPCs.NPCType;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;

@Singleton
public class NPCManager {

    public final ArrayList<NPC> npcs = new ArrayList<>();


    @Inject
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
