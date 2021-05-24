package moe.quill.NPCManager.NPCs;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Villager;

public class Cryptologist extends NPC {

    public Cryptologist(NamespacedKey keys) {
        super(Villager.Profession.LIBRARIAN, keys);
    }
}
